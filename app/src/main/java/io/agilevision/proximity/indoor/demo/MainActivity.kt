/*package io.agilevision.proximity.indoor.demo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import io.agilevision.proximity.indoor.*

class MainActivity : AppCompatActivity(), OnScanError, CoordinateTracker, DistanceTracker {

    @BindView(R.id.text_x)
    lateinit var tx: TextView
    @BindView(R.id.text_y)
    lateinit var ty: TextView
    @BindView(R.id.text_error)
    lateinit var error: TextView
    @BindView(R.id.beacon_a)
    lateinit var ba: TextView
    @BindView(R.id.beacon_b)
    lateinit var bb: TextView
    @BindView(R.id.beacon_c)
    lateinit var bc: TextView
    @BindView(R.id.beacon_d)
    lateinit var bd: TextView
    @BindView(R.id.beacon_e)
    lateinit var be: TextView
    @BindView(R.id.beacon_scan_btn)
    lateinit var btnScan: Button

    var mm: MutableMap<Beacon, Pair<TextView, String>> = mutableMapOf()
    lateinit var bs: BeaconsSearcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.setDebug(BuildConfig.DEBUG)
        ButterKnife.bind(this)
        val a = Beacon("bc1933dfea1ffa5ea9ff", "db4ed86efe94")
        val b = Beacon("01927292727291027373", "773892109838")
        val c = Beacon("60471740639636040747", "474107704704")
        val d = Beacon("69403602962961514142", "852696929626")
        val e = Beacon("69745341528751453770", "464257943216")


        mm.put(a, Pair(ba, "A (bc1933dfea1ffa5ea9ff)"));
        mm.put(b, Pair(bb, "B (01927292727291027373)"));
        mm.put(c, Pair(bc, "C (60471740639636040747)"));
        mm.put(d, Pair(bd, "D (69403602962961514142)"));
        mm.put(e, Pair(be, "E (69745341528751453770)"));
        Log.i("Testing", a.toString())

        val cc = CoordinateBuilder()
                .addBeacon(a, XYPoint(0.0, 0.0))
                .addBeacon(b, XYPoint(4.09, 0.0))
                .addBeacon(c, XYPoint(4.09, 2.88))
                .addBeacon(d, XYPoint(0.0, 2.88))
                .addBeacon(e, XYPoint(2.045, 1.44))
                .trackCoordinate(this)
                .trackDistance(this)

                .build()
        bs = BeaconsSearcher(this, cc)
        onScanClick(null)

    }

    @OnClick(R.id.beacon_scan_btn)
    fun onScanClick(btn: Button?) {
        if (!isBluetoothGranted()) {
            askBTPermissions()
        } else {
            error.visibility = GONE
            if (bs.scanRunning) {
                bs.stopScan()
                btnScan.setText("Start scan")
            } else {
                bs.scanForDevices(this)
                btnScan.setText("Stop scann")
            }
        }
    }

    override fun onCoordinateChange(x: Double, y: Double) {
        tx.setText(getString(R.string.x_coordd, x))
        ty.setText(getString(R.string.y_coord, y))
    }

    override fun onError(description: OnScanError.ErrorType) {
        btnScan.setText("Start scan")
        error.visibility = VISIBLE
        error.setText(getString(R.string.err_scan, description.description))
    }

    override fun onDistanceChange(i: Beacon, current: Double, medium: Double) {
        mm[i]?.first?.setText(getString(R.string.beacon_distance, mm[i]?.second, current, medium))
    }

    private fun isPermissionGranted(c: Context, vararg permissions: String): Boolean {
        var granted = true
        for (permission in permissions) {
            granted = granted and (PackageManager.PERMISSION_GRANTED
                    == ContextCompat.checkSelfPermission(c, permission))
        }
        return granted
    }

    private fun isBluetoothGranted(): Boolean {
        return isPermissionGranted(this,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.BLUETOOTH_ADMIN,
                Manifest.permission.BLUETOOTH
        )
    }

    private fun askBTPermissions() {
        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.BLUETOOTH_ADMIN,
                        Manifest.permission.BLUETOOTH
                ),
                444)
    }
}
*/