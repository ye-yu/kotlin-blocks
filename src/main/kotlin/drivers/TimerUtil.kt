package drivers

import structs.WindowedTimer

object TimerUtil {
    fun stamp(windowedTimer: WindowedTimer) {
        val now = System.currentTimeMillis()
        val lastMilliCalled = windowedTimer.lastMilliCalled
        if (lastMilliCalled != null) {
            val elapsed = now - lastMilliCalled
            FixedSizeArrayUtil.put(windowedTimer.elapsedHistory, elapsed)
            val nonNullHistory = FixedSizeArrayUtil.filterNonNull(windowedTimer.elapsedHistory)
            windowedTimer.totalElapsed = nonNullHistory.fold(0) { it, acc -> it + acc }
            windowedTimer.averageCalled = windowedTimer.totalElapsed.toDouble() / nonNullHistory.size
        }
        windowedTimer.lastMilliCalled = now
    }
}