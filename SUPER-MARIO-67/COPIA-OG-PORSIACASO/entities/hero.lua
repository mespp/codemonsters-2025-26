local hero = {
    x = 20,
    y = 10,
    update = function(dt)
        keypressed = function(d)
            x = x + 10
        end
    end,
    draw = function()
        love.graphics.draw(hero_sprite, x, y)
    end
}

return hero
