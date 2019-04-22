package uk.co.massimocarli.animationtest.animation

import android.view.animation.Animation
import android.view.animation.Transformation

class InvertAnimation : Animation() {

  companion object {
    /**
     * The default rate for the rotation
     */
    private const val DEFAULT_ROTATION_RATE = 1.0f

    /**
     * The current rate of the rotation
     */
    private const val rate = DEFAULT_ROTATION_RATE
  }

  /**
   * The rotation rate
   */
  var rate: Float = DEFAULT_ROTATION_RATE

  /**
   * X for the Pivot
   */
  private var pivotX: Float = 0F

  /**
   * Y for the Pivot
   */
  private var pivotY: Float = 0F

  override fun initialize(
    width: Int,
    height: Int,
    parentWidth: Int,
    parentHeight: Int
  ) {
    super.initialize(width, height, parentWidth, parentHeight)
    // We center the  pivot
    pivotX = (width / 2).toFloat()
    pivotY = (height / 2).toFloat()
    // Se the duration into 1 second
    duration = 5000L
    // We set the animation as peristence
    fillAfter = true
  }

  override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
    // We get the reference to the current transformation Matrix
    val matrix = t.matrix
    // We apply our transformation
    var rotateValue = interpolatedTime * 180f * rate
    rotateValue = if (rotateValue < 180f) rotateValue else 180f
    matrix.setRotate(rotateValue, pivotX, pivotY)
  }
}