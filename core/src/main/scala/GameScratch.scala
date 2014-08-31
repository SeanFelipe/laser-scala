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
    drawLines()
    batch.end()
  }

  def drawLines() {
    val sx = 100
    val ex = 300
    val y = 100
    val numlines = 5
    val transparency_delta = 100f / numlines / 100f
//    println(transparency_delta)
    var transparency = 0f

    shapeRenderer.begin(ShapeType.Line)
    for ( i <- 1 to numlines ) {
      transparency = transparency + transparency_delta * i
//      println(transparency)
      shapeRenderer.setColor(1, 1, 0, transparency)
      shapeRenderer.line(sx, y + i, ex, y + i)
    }
    shapeRenderer.end()
  }

  def resize(width: Int, height: Int) = {}
  def show() = {}
  def hide() = {}
  def pause() = {}
  def resume() = {}
  def dispose() = {}

}


