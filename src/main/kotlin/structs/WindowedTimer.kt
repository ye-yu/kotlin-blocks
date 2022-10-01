package structs

import drivers.FixedSizeArrayUtil

class WindowedTimer {
    var lastMilliCalled: Long? = null
    var averageCalled = 0.0
    var totalElapsed = 0L
    val elapsedHistory = FixedSizeArrayUtil.new<Long>(50)
}