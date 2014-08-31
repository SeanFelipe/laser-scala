package scratch

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20


class GameScratch extends Game {
  override def create() {
    this.setScreen(new HappyScreen())
  }
}

class HappyScreen extends Screen {

  val batch = new SpriteBatch()
  val laser = new LaserBeam(500f)

  override def render(delta: Float) = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.begin()
    laser.draw(batch)
    batch.end();
  }

  def resize(width: Int, height: Int) = {}
  def show() = {}
  def hide() = {}
  def pause() = {}
  def resume() = {}
  def dispose() = {}

}

class LaserBeam extends Sprite {

  //add additional constructor
  def this(length: Float) {
    this()
    val txsource = new Texture(Gdx.files.internal("wide-mid.png"))
    set(new Sprite(txsource))
    setPosition(100f, 100f)
    setRotation(90)
    setSize(getHeight(), length)

  }

}

