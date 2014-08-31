package scratch

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType


class GameScratch extends Game {
  override def create() {
    this.setScreen(new HappyScreen())
  }
}

class HappyScreen extends Screen {

  val batch = new SpriteBatch
  val shapeRenderer = new ShapeRenderer

  override def render(delta: Float) = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE)
    batch.begin()
    shapeRenderer.begin(ShapeType.Line)
    shapeRenderer.setColor(1, 1, 0, 1)
    shapeRenderer.line(100, 100, 500, 500)
    shapeRenderer.end()
    batch.end()
  }

  def resize(width: Int, height: Int) = {}
  def show() = {}
  def hide() = {}
  def pause() = {}
  def resume() = {}
  def dispose() = {}

}


