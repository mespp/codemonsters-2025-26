local screen = {
    load = function()
        background_image = love.graphics.newImage("assets/background.png")
        hero_module = require("../entities/hero")
        hero = hero_module.new_hero(0, 0)
        coin_module = require("../entities/coin")
        coin = coin_module.new_coin(10, 0)
    end,
    update = function(dt)
        hero:update(dt) -- hero.update(hero, dt)
        coin:update(dt) -- coin.update(coin, dt)
    end,
    draw = function()
        love.graphics.draw(background_image, 0,0)
        hero:draw() -- hero.draw(hero)
        hero:draw_hitbox()
        coin:draw() -- coin.draw(coin)
        coin:draw_hitbox()
    end,
    keypressed = function(key)
        hero:keypressed(key)
    end,
    keyreleased = function(key)
        hero:keyreleased(key)
    end
}

return screen
