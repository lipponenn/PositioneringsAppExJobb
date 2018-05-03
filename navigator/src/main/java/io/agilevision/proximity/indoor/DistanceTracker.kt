package io.agilevision.proximity.indoor


interface DistanceTracker {

    /**
     * This method is called when distance to beacon is changed
     *
     * @param i - identifier of the beacon
     * @param current - current distance to the beacon at this moment of time
     * @param medium - calculated average distance to beacon for [com.agilevision.navigator.CoordinateBuilder.cacheTime]
     * */
    fun onDistanceChange(i: Beacon, current: Double, medium: Double)
}