import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Looper


const val THEME_PREFERENCES_AND_HISTORY = "theme_preferences"
private const val CLICK_DEBOUNCE_DELAY = 1000L
val handler = android.os.Handler(Looper.getMainLooper())
private var isClickable = true
const val textOfSearch = "TEXT_OF_SEARCH"

fun clickDebounce(): Boolean {
    val current = isClickable
    if (isClickable) {
        isClickable = false
        handler.postDelayed({ isClickable = true }, CLICK_DEBOUNCE_DELAY)
    }
    return current
}

fun sharedPreferencesInit(context: Context): SharedPreferences =
    context.getSharedPreferences(THEME_PREFERENCES_AND_HISTORY, MODE_PRIVATE)

