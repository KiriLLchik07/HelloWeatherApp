import java.text.SimpleDateFormat

class Utils {
    companion object {
        fun timesTampToHumanDate(timeStamp: Long, format: String): String {
            val sdf = SimpleDateFormat(format)
            return sdf.format(timeStamp * 1000)
        }

        fun buildIcon (icon: String, isBigSize: Boolean = true): String {
            return if (isBigSize) {
                "https://openweathermap.org/img/wn/$icon@2x.png"
            }
            else {
                "https://openweathermap.org/img/wn/$icon.png"
            }
        }
    }
}