package scratch

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
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

  val batch = new SpriteBatch
  //val laser = new LaserBeam(500f)
  val l2 = new LaserBeam2

  override def render(delta: Float) = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE);
    batch.begin()
    //laser.draw(batch)
    l2.draw(batch)
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

class LaserBeam2 {
  val tx_center = new Texture(Gdx.files.internal("wide-mid.png"))
  val tx_start = new Texture(Gdx.files.internal("wide-start.png"))
  val tx_end = new Texture(Gdx.files.internal("wide-end.png"))

  val spr_center = new Sprite(tx_center)
  val spr_start = new Sprite(tx_start)
  val spr_end = new Sprite(tx_end)

  spr_center.setSize(spr_center.getHeight(), 300)
  println(spr_center.getWidth())
  val startx = 100
  val startx_mid = startx + spr_start.getWidth()
  val startx_end = startx_mid + 300

  spr_start.setPosition(startx, 100)
  spr_center.setPosition(startx_mid, 100)
  spr_end.setPosition(startx_end, 100)

  val sprites = Array(spr_center, spr_start, spr_end)

  for (s <- sprites) {
    //s.setPosition(100f, 100f)
    s.setRotation(270)
  }

  def draw(batch: SpriteBatch) {
    for (s <- sprites) {
      s.draw(batch)
    }
  }

}
