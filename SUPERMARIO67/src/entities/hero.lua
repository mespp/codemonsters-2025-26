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

        update = function(self, dt)
            if self._left_pressed then
                self.x = self.x - 1
            end
            if self._right_pressed then
                self.x = self.x + 1
            end
            
            if self._space_pressed then
                self.y = self.y - 10
            end

            while self.y < 121 do
                self.y = self.y + 20
            end
            
        end,

        draw = function(self)
            -- dibujar el héroe
            love.graphics.draw(self.image, self.x + self.img_shift_x, self.y + self.img_shift_y)
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
            elseif key == "space" then
                self._space_pressed = true
            end
        end,

        keyreleased = function(self, key)
            if key == "left" then
                self._left_pressed = false
            elseif key == "right" then
                self._right_pressed = false
            elseif key == "space" then
                self._space_pressed = false
            end
        end,
    }
    return hero 
end

return my_module

