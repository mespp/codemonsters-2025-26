local my_module = {}

function my_module.new_hero(xinit, yinit)
    local hero = {
        x = 20,
        y = 121,
        img_shift_x = -55,
        img_shift_y = -121,
        hitbox = {x = 4, y = 0, w = 30, h = 52},

        currentFrame = 1,
        animationTimer = 0,
        frameRate = 1 / 10,

        image = love.graphics.newImage("assets/fishy/baseFishy.png"),

        idleFrames = {
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0001.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0002.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0003.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0004.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0005.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0006.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0007.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0008.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0009.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0010.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0011.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0012.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0013.png"),
            love.graphics.newImage("assets/fishy/idle/fishy_idle_0014.png"),
        },
        movingRightFrames = {
            love.graphics.newImage("assets/fishy/moving/movingRight/fishy_movingRight_0001.png"),
            love.graphics.newImage("assets/fishy/moving/movingRight/fishy_movingRight_0002.png"),
            love.graphics.newImage("assets/fishy/moving/movingRight/fishy_movingRight_0003.png"),
            love.graphics.newImage("assets/fishy/moving/movingRight/fishy_movingRight_0004.png"),
            love.graphics.newImage("assets/fishy/moving/movingRight/fishy_movingRight_0005.png"),
        },
        movingLeftFrames = {
            love.graphics.newImage("assets/fishy/moving/movingLeft/fishy_movingLeft_0001.png"),
            love.graphics.newImage("assets/fishy/moving/movingLeft/fishy_movingLeft_0002.png"),
            love.graphics.newImage("assets/fishy/moving/movingLeft/fishy_movingLeft_0003.png"),
            love.graphics.newImage("assets/fishy/moving/movingLeft/fishy_movingLeft_0004.png"),
            love.graphics.newImage("assets/fishy/moving/movingLeft/fishy_movingLeft_0005.png"),
        },

        _left_pressed = false,
        _right_pressed = false,
        _space_pressed = false,

        states = {
            idle = {
                init = function(self)
                end,

                update = function(self, dt)
                    self.animationTimer = self.animationTimer + dt
                    if self.animationTimer >= self.frameRate then
                        self.animationTimer = self.animationTimer - self.frameRate
                        self.currentFrame = (self.currentFrame % #self.idleFrames) + 1
                    end
                end,

                draw = function(self, dt)
                    local frameToDrawIdle = self.idleFrames[self.currentFrame]
                    love.graphics.draw(frameToDrawIdle, self.x + self.img_shift_x, self.y + self.img_shift_y)
                end
            },

            moving = {
                init = function(self)
                    univers = love.graphics.newFont("assets/UniversBold.ttf")
                    love.graphics.setFont(univers)
                end,

                update = function(self, dt)
                    self.animationTimer = self.animationTimer + dt
                    if self.animationTimer >= self.frameRate then
                        self.animationTimer = self.animationTimer - self.frameRate
                        self.currentFrame = (self.currentFrame % #self.movingRightFrames) + 1
                    end
                
                    if self._left_pressed then
                        self.x = self.x - 2
                        frameToDrawMoving = self.movingLeftFrames[self.currentFrame]
                    end
                    if self._right_pressed then
                        self.x = self.x + 2
                        frameToDrawMoving = self.movingRightFrames[self.currentFrame]
                    end
                    if self.x < -self.hitbox.x then
                        self.x = -self.hitbox.x
                    end
                    if self.x > FIXED_WIDTH - self.hitbox.x - self.hitbox.w then
                        self.x = FIXED_WIDTH - self.hitbox.x - self.hitbox.w
                    end
                    if frameToDrawMoving == nil then
                        frameToDrawMoving = self.image
                    end
                end,

                draw = function(self, dt)
                    local frameToDrawMoving = frameToDrawMoving
                    love.graphics.draw(frameToDrawMoving, self.x + self.img_shift_x, self.y + self.img_shift_y)
                end
            },

            jumping = {
                init = function(self)
                    -- print("inicio salto")
                    self.vel_y = 250
                end,
                update = function(self, dt)
                    self.y = self.y - self.vel_y * dt
                    self.vel_y = self.vel_y -  400 * dt -- gravedad
                    if self.y >= 121 then
                        self.y = 121
                        self.set_state(self, "idle")
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
                self:set_state("moving")
                self._left_pressed = true
            elseif key == "right" then
                self:set_state("moving")
                self._right_pressed = true
            elseif key == "space" and self._state == "moving" or "idle" then
                self:set_state("jumping")
            end
        end,

        keyreleased = function(self, key)
            if key == "left" then
                self:set_state("idle")
                self._left_pressed = false
            elseif key == "right" then
                self:set_state("idle")
                self._right_pressed = false
            end
        end,
    }
    hero:set_state("idle")
    return hero
end

return my_module


