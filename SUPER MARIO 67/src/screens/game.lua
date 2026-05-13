local screen = {
    load = function() 
        hero = require("../entities/hero") 
    end,
    update = function(dt) 
        hero.update(dt)
        function love.keypressed( d )
        if key == "return" then
            text = "d!"
        end
end
    end,
    draw = function() 
        love.graphics.print("*** PARTIDA ***", 400, 300) 
        hero.draw()
    end,
}
return screen