local my_module = {}

function my_module.new_hero(xinit, yinit)
    local hero = {
        x = 20,
        y = 121,
        img_shift_x = -55,
        img_shift_y = -121,
        hitbox = {x = 4, y = 0, w = 30, h = 52},
        image = love.graphics.newImage("assets/hero.png"),
        _left_pressed = false,
        _right_pressed = false,
        _space_pressed = false,
        _salt = false,

        states = {
            moving = {
                init = function(self)
                    semen = love.graphics.newFont("assets/UniversBold.ttf")
                    love.graphics.setFont(semen)
                end,
                update = function(self, dt)
                    if self._left_pressed then
                        self.x = self.x - 2
                    end
                    if self._right_pressed then
                        self.x = self.x + 2
                    end
                end,
                draw = function(self, dt)
                    love.graphics.print("PSOE", 100 , 120)
                    love.graphics.draw(self.image, self.x + self.img_shift_x, self.y + self.img_shift_y)
                end
            },
            jumping = {
                init = function(self)
                    print("inicio salto")
                    self.vel_y = 250
                end,
                update = function(self, dt)
                    self.y = self.y - self.vel_y * dt
                    self.vel_y = self.vel_y -  400 * dt -- gravedad
                    if self.y >= 121 then
                        self.y = 121
                        self.set_state(self, "moving")
                    end
                end,
                draw = function(self, dt)
                    love.graphics.draw(self.image, self.x + self.img_shift_x, self.y + self.img_shift_y)
                end
            }
        },
        set_state = function(self, new_state)
            self._state = new_state
            self.states[new_state].init(self)
        end,
        update = function(self, dt)
            self.states[self._state].update(self, dt)
        end,
        draw = function(self)
            -- dibujar el héroe
            love.graphics.setColor(1, 1, 1, 1)
            self.states[self._state].draw(self)
        end,
        draw_hitbox = function(self)
            love.graphics.rectangle(
                "line",
                self.x + self.hitbox.x,
                self.y + self.hitbox.y,
                self.hitbox.w, self.hitbox.h)
        end,
        keypressed = function(self, key)
            if key == "left" then
                self._left_pressed = true
            elseif key == "right" then
                self._right_pressed = true
            elseif key == "space" and self._state == "moving" then
                self:set_state("jumping")
            end
        end,
        keyreleased = function(self, key)
            if key == "left" then
                self._left_pressed = false
            elseif key == "right" then
                self._right_pressed = false
            end
        end,
    }
    hero:set_state("moving")
    return hero
end

return my_module


