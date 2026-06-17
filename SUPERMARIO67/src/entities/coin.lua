local my_module = {}

function my_module.new_coin(xinit, yinit)
    local coin = {
        x = 50,
        y = 121,
        img_shift_x = -115,
        img_shift_y = -138,
        hitbox = {x = 0, y = 0, w = 27, h = 26},

        currentFrame = 1,
        animationTimer = 0,
        frameRate = 1 / 10,

        image = love.graphics.newImage("assets/coin/coin_0001.png"),
        
        coinFrames = {
            love.graphics.newImage("assets/coin/coin_0001.png"),
            love.graphics.newImage("assets/coin/coin_0002.png"),
            love.graphics.newImage("assets/coin/coin_0003.png"),
            love.graphics.newImage("assets/coin/coin_0004.png"),
            love.graphics.newImage("assets/coin/coin_0005.png"),
        },

        update = function(self, dt)
            self.animationTimer = self.animationTimer + dt
            if self.animationTimer >= self.frameRate then
                self.animationTimer = self.animationTimer - self.frameRate
                self.currentFrame = (self.currentFrame % #self.coinFrames) + 1
            end
        end,
        
        draw = function(self, dt)
            love.graphics.draw(self.coinFrames[self.currentFrame], self.x + self.img_shift_x, self.y + self.img_shift_y)
        end,

        draw_hitbox = function(self)
            love.graphics.rectangle(
                "line",
                self.x + self.hitbox.x,
                self.y + self.hitbox.y,
                self.hitbox.w, self.hitbox.h)
        end
    }
    return coin
end

return my_module