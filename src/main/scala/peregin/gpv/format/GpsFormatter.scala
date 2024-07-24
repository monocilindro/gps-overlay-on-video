package peregin.gpv.format


object GpsFormatter {

  def formatLon(lon: Double): String = {
    return formatAxis("WE", lon)
  }

  def formatLat(lon: Double): String = {
    return formatAxis("SN", lon)
  }

  private def formatAxis(negPos: String, n: Double): String = {
    var out: String = String.valueOf(negPos.charAt(if (n < 0) 0 else 1))

    var remain = Math.abs(n);

    val degree = Math.floor(remain);
    out += String.format("%03.0f°", degree)
    remain = 60*(remain - degree)

    val minute = Math.floor(remain);
    out += String.format("%02.0f'", minute)
    remain = 60*(remain - minute)

    out += String.format("%07.4f\"", remain)

    return out;
  }
}
