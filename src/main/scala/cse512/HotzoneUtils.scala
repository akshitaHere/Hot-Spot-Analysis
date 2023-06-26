package cse512

object HotzoneUtils {

  def ST_Contains(queryRectangle: String, pointString: String ): Boolean = {
    val rectangleCoordinates = queryRectangle.split(",")
    val d1x = rectangleCoordinates(0).toDouble
    val d1y = rectangleCoordinates(1).toDouble
    val d2x = rectangleCoordinates(2).toDouble
    val d2y = rectangleCoordinates(3).toDouble

    val pointCoordinates = pointString.split(",")
    val px = pointCoordinates(0).toDouble
    val py = pointCoordinates(1).toDouble

    val xlow = Math.min(d1x, d2x)
    val xup = Math.max(d1x, d2x)
    val ylow = Math.min(d1y, d2y)
    val yup = Math.max(d1y, d2y)

    if ( queryRectangle == null || pointString == null ) {
      return false
    }

    if (( px >= xlow && px <= xup ) && ( py >= ylow && py <= yup )) {
      return true
    } else {
      return false
    }
  }
  
}
