package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import vn.map4d.map.annotations.MFDotPattern
import vn.map4d.map.annotations.MFPolygonOptions
import vn.map4d.map.annotations.MFPolyline
import vn.map4d.map.annotations.MFPolylineOptions
import vn.map4d.map.core.MFMapView
import vn.map4d.map.core.Map4D
import vn.map4d.map.core.OnMapReadyCallback
import vn.map4d.types.MFLocationCoordinate

class MainActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {
    private var map4D: Map4D? = null

    private var mapView: MFMapView? = null

    private val isLocationEnabed = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView = findViewById<MFMapView>(R.id.mapView)
        mapView?.getMapAsync(this)
    }

    override fun onMapReady(map4D: Map4D) {
        this.map4D = map4D

        map4D.addPolyline(
            MFPolylineOptions().color(Color.RED)
                .add(MFLocationCoordinate(10.772431, 106.699380))
                .add(MFLocationCoordinate(10.773201, 106.700147))
                .add(MFLocationCoordinate(10.771783, 106.700763))
        )

        val line: MFPolyline? = map4D.addPolyline(
            MFPolylineOptions().color(Color.RED)
                .width(8f) //          .pattern(new MFDashPattern(8, 8))
                .pattern(MFDotPattern(1))
                .add(MFLocationCoordinate(10.772302, 106.701901))
                .add(MFLocationCoordinate(10.773267, 106.701493))
                .add(MFLocationCoordinate(10.773599, 106.702835))
        )

        map4D.addPolygon(
            MFPolygonOptions()
                .add(MFLocationCoordinate(10.773201, 106.700147))
                .add(MFLocationCoordinate(10.771783, 106.700763))
                .add(MFLocationCoordinate(10.772302, 106.701901))
                .add(MFLocationCoordinate(10.773267, 106.701493))
                .add(MFLocationCoordinate(10.773201, 106.700147))
                .visible(true)
                .fillColor(ColorUtils.setAlphaComponent(Color.RED, 125))
                .addHole(
                    MFLocationCoordinate(10.772785, 106.700738),
                    MFLocationCoordinate(10.772904, 106.701304),
                    MFLocationCoordinate(10.772752, 106.701319),
                    MFLocationCoordinate(10.772650, 106.700651),
                    MFLocationCoordinate(10.772785, 106.700738)
                )
                .addHole(
                    MFLocationCoordinate(10.772356, 106.700802),
                    MFLocationCoordinate(10.772479, 106.701413),
                    MFLocationCoordinate(10.772285, 106.701497),
                    MFLocationCoordinate(10.772059, 106.701064),
                    MFLocationCoordinate(10.772356, 106.700802)
                )
        )
    }

    override fun onClick(v: View?) {
    }
}