package com.jbt.model;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Vin implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    private String brand;

    /**
     * vehicle_model_code
     */
    private String vehicleModelCode;

    /**
     * vehicle_level
     */
    private String vehicleLevel;

    /**
     * vin
     */
    private String vin;

    /**
     * total_mass
     */
    private String totalMass;

    /**
     * vehicle_series_name
     */
    private String vehicleSeriesName;

    /**
     * fuel_oil_type
     */
    private String fuelOilType;

    /**
     * speed_limit
     */
    private String speedLimit;

    /**
     * 单位:ml
     */
    private String displacement;

    /**
     * rated_power
     */
    private String ratedPower;

    /**
     * gearbox_type
     */
    private String gearboxType;

    /**
     * seat_total
     */
    private String seatTotal;

    /**
     * wheel_base
     */
    private String wheelBase;

    /**
     * engine_type
     */
    private String engineType;

    /**
     * engine_company
     */
    private String engineCompany;

    /**
     * vehicle_length
     */
    private String vehicleLength;

    /**
     * vehicle_high
     */
    private String vehicleHigh;

    /**
     * vehicle_wide
     */
    private String vehicleWide;

    /**
     * vehicle_weight
     */
    private String vehicleWeight;

    /**
     * axle_total
     */
    private String axleTotal;

    /**
     * tyre
     */
    private String tyre;

    /**
     * front_suspension_high
     */
    private String frontSuspensionHigh;

    /**
     * behind_suspension_high
     */
    private String behindSuspensionHigh;

    /**
     * front_wheel_track
     */
    private String frontWheelTrack;

    /**
     * behind_wheel_track
     */
    private String behindWheelTrack;

    /**
     * product_name
     */
    private String productName;

    /**
     * drive_tye
     */
    private String driveTye;

    /**
     * consumption_city
     */
    private String consumptionCity;

    /**
     * consumption_suburb
     */
    private String consumptionSuburb;

    /**
     * consumption_synthetic
     */
    private String consumptionSynthetic;

    /**
     * create_time
     */
    private Long createTime;

    /**
     * wmi
     */
    private String wmi;

    /**
     * brand_id
     */
    private Integer brandId;


    public Vin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleModelCode() {
        return vehicleModelCode;
    }

    public void setVehicleModelCode(String vehicleModelCode) {
        this.vehicleModelCode = vehicleModelCode;
    }

    public String getVehicleLevel() {
        return vehicleLevel;
    }

    public void setVehicleLevel(String vehicleLevel) {
        this.vehicleLevel = vehicleLevel;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTotalMass() {
        return totalMass;
    }

    public void setTotalMass(String totalMass) {
        this.totalMass = totalMass;
    }

    public String getVehicleSeriesName() {
        return vehicleSeriesName;
    }

    public void setVehicleSeriesName(String vehicleSeriesName) {
        this.vehicleSeriesName = vehicleSeriesName;
    }

    public String getFuelOilType() {
        return fuelOilType;
    }

    public void setFuelOilType(String fuelOilType) {
        this.fuelOilType = fuelOilType;
    }

    public String getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(String speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(String ratedPower) {
        this.ratedPower = ratedPower;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public String getSeatTotal() {
        return seatTotal;
    }

    public void setSeatTotal(String seatTotal) {
        this.seatTotal = seatTotal;
    }

    public String getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(String wheelBase) {
        this.wheelBase = wheelBase;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineCompany() {
        return engineCompany;
    }

    public void setEngineCompany(String engineCompany) {
        this.engineCompany = engineCompany;
    }

    public String getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        this.vehicleLength = vehicleLength;
    }

    public String getVehicleHigh() {
        return vehicleHigh;
    }

    public void setVehicleHigh(String vehicleHigh) {
        this.vehicleHigh = vehicleHigh;
    }

    public String getVehicleWide() {
        return vehicleWide;
    }

    public void setVehicleWide(String vehicleWide) {
        this.vehicleWide = vehicleWide;
    }

    public String getVehicleWeight() {
        return vehicleWeight;
    }

    public void setVehicleWeight(String vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public String getAxleTotal() {
        return axleTotal;
    }

    public void setAxleTotal(String axleTotal) {
        this.axleTotal = axleTotal;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public String getFrontSuspensionHigh() {
        return frontSuspensionHigh;
    }

    public void setFrontSuspensionHigh(String frontSuspensionHigh) {
        this.frontSuspensionHigh = frontSuspensionHigh;
    }

    public String getBehindSuspensionHigh() {
        return behindSuspensionHigh;
    }

    public void setBehindSuspensionHigh(String behindSuspensionHigh) {
        this.behindSuspensionHigh = behindSuspensionHigh;
    }

    public String getFrontWheelTrack() {
        return frontWheelTrack;
    }

    public void setFrontWheelTrack(String frontWheelTrack) {
        this.frontWheelTrack = frontWheelTrack;
    }

    public String getBehindWheelTrack() {
        return behindWheelTrack;
    }

    public void setBehindWheelTrack(String behindWheelTrack) {
        this.behindWheelTrack = behindWheelTrack;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDriveTye() {
        return driveTye;
    }

    public void setDriveTye(String driveTye) {
        this.driveTye = driveTye;
    }

    public String getConsumptionCity() {
        return consumptionCity;
    }

    public void setConsumptionCity(String consumptionCity) {
        this.consumptionCity = consumptionCity;
    }

    public String getConsumptionSuburb() {
        return consumptionSuburb;
    }

    public void setConsumptionSuburb(String consumptionSuburb) {
        this.consumptionSuburb = consumptionSuburb;
    }

    public String getConsumptionSynthetic() {
        return consumptionSynthetic;
    }

    public void setConsumptionSynthetic(String consumptionSynthetic) {
        this.consumptionSynthetic = consumptionSynthetic;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getWmi() {
        return wmi;
    }

    public void setWmi(String wmi) {
        this.wmi = wmi;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vin{" +
                "brand='" + brand + '\'' +
                ", vehicleModelCode='" + vehicleModelCode + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }


}