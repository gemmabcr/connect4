package models

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RegistryTest {
    private lateinit var game: Game
    private lateinit var registry: Registry

    @BeforeEach
    fun before(){
        game = Game()
        registry = Registry(game)
    }

    @Test
    fun `when created return undoable and redoable false` (){
        assertEquals(registry.undoable(), false)
        assertEquals(registry.redoable(), false)
    }
}