package cse512

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

object HotcellUtils {
  val coordinateStep = 0.01

  def CalculateCoordinate(inputString: String, coordinateOffset: Int): Int =
  {
    // Configuration variable:
    // Coordinate step is the size of each cell on x and y
    var result = 0
    coordinateOffset match
    {
      case 0 => result = Math.floor((inputString.split(",")(0).replace("(","").toDouble/coordinateStep)).toInt
      case 1 => result = Math.floor(inputString.split(",")(1).replace(")","").toDouble/coordinateStep).toInt
      // We only consider the data from 2009 to 2012 inclusively, 4 years in total. Week 0 Day 0 is 2009-01-01
      case 2 => {
        val timestamp = HotcellUtils.timestampParser(inputString)
        result = HotcellUtils.dayOfMonth(timestamp) // Assume every month has 31 days
      }
    }
    return result
  }

  def timestampParser (timestampString: String): Timestamp =
  {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val parsedDate = dateFormat.parse(timestampString)
    val timeStamp = new Timestamp(parsedDate.getTime)
    return timeStamp
  }

  def dayOfYear (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_YEAR)
  }

  def dayOfMonth (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_MONTH)
  }
 def calculatew(minX: Int, minY: Int, minZ: Int, maxX: Int, maxY: Int, maxZ: Int,X: Int, Y:Int, Z:Int): Int = {

    var num = 0

    if (Z == minZ || Z == maxZ)
    {
    num = num + 1
    }
    if (Y == minY || Y == maxY)
    {
    num = num + 1
    }
    if (X == minX || X == maxX){
    num = num + 1
    }


    num match {
    case 1 => 18
    case 2 => 12
    case 3 => 8
    case _ => 27
    }
 }

 def FGDots(numCells: Int, x: Int, y: Int, z: Int, w: Int, info: Int, average: Double, stndev: Double): Double = {
 var w_here: Double = w.toDouble
 var cellcount: Double = numCells.toDouble
  (info.toDouble - (average * w_here)) / (stndev * math.sqrt(((w_here * cellcount) - (w_here * w_here)) / (cellcount - 1.0)))
 }
  // YOU NEED TO CHANGE THIS PART
}