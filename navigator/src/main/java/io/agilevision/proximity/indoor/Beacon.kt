package io.agilevision.proximity.indoor



class Beacon(var namespace: String, var instance: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Beacon

        if (namespace != other.namespace) return false
        if (instance != other.instance) return false

        return true
    }

    override fun hashCode(): Int {
        var result = namespace.hashCode()
        result = 31 * result + instance.hashCode()
        return result
    }

    override fun toString(): String {
        return "$namespace:$instance"
    }
}