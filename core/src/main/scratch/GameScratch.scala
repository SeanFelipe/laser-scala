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
  val laser = new Texture(Gdx.files.internal("wide-mid.png"))
  val sprite = new Sprite(laser)
  val texture = new Texture(Gdx.files.internal("wide-mid.png"))

  override def render(delta: Float) = {
    Gdx.gl.glClearColor(1, 1, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.begin()
    batch.draw(texture, 100, 100);
    batch.end();
  }

  def resize(width: Int, height: Int) = {}
  def show() = {}
  def hide() = {}
  def pause() = {}
  def resume() = {}
  def dispose() = {}

}
