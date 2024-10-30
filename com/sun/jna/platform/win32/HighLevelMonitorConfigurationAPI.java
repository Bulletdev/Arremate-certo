/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.platform.EnumUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface HighLevelMonitorConfigurationAPI
/*     */ {
/*     */   public enum MC_CAPS
/*     */     implements FlagEnum
/*     */   {
/*  44 */     MC_CAPS_NONE(0),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     MC_CAPS_MONITOR_TECHNOLOGY_TYPE(1),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     MC_CAPS_BRIGHTNESS(2),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     MC_CAPS_CONTRAST(4),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     MC_CAPS_COLOR_TEMPERATURE(8),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     MC_CAPS_RED_GREEN_BLUE_GAIN(16),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     MC_CAPS_RED_GREEN_BLUE_DRIVE(32),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     MC_CAPS_DEGAUSS(64),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     MC_CAPS_DISPLAY_AREA_POSITION(128),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     MC_CAPS_DISPLAY_AREA_SIZE(256),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     MC_CAPS_RESTORE_FACTORY_DEFAULTS(1024),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     MC_CAPS_RESTORE_FACTORY_COLOR_DEFAULTS(2048),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     MC_RESTORE_FACTORY_DEFAULTS_ENABLES_MONITOR_SETTINGS(4096);
/*     */     
/*     */     private int flag;
/*     */ 
/*     */     
/*     */     MC_CAPS(int param1Int1) {
/* 112 */       this.flag = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getFlag() {
/* 118 */       return this.flag;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_SUPPORTED_COLOR_TEMPERATURE
/*     */     implements FlagEnum
/*     */   {
/* 130 */     MC_SUPPORTED_COLOR_TEMPERATURE_NONE(0),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     MC_SUPPORTED_COLOR_TEMPERATURE_4000K(1),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     MC_SUPPORTED_COLOR_TEMPERATURE_5000K(2),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     MC_SUPPORTED_COLOR_TEMPERATURE_6500K(4),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     MC_SUPPORTED_COLOR_TEMPERATURE_7500K(8),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     MC_SUPPORTED_COLOR_TEMPERATURE_8200K(16),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     MC_SUPPORTED_COLOR_TEMPERATURE_9300K(32),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     MC_SUPPORTED_COLOR_TEMPERATURE_10000K(64),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     MC_SUPPORTED_COLOR_TEMPERATURE_11500K(128);
/*     */     
/*     */     private int flag;
/*     */ 
/*     */     
/*     */     MC_SUPPORTED_COLOR_TEMPERATURE(int param1Int1) {
/* 176 */       this.flag = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getFlag() {
/* 182 */       return this.flag;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_DISPLAY_TECHNOLOGY_TYPE
/*     */   {
/* 198 */     MC_SHADOW_MASK_CATHODE_RAY_TUBE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     MC_APERTURE_GRILL_CATHODE_RAY_TUBE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     MC_THIN_FILM_TRANSISTOR,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     MC_LIQUID_CRYSTAL_ON_SILICON,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     MC_PLASMA,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     MC_ORGANIC_LIGHT_EMITTING_DIODE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     MC_ELECTROLUMINESCENT,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     MC_MICROELECTROMECHANICAL,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     MC_FIELD_EMISSION_DEVICE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends com.sun.jna.ptr.ByReference
/*     */     {
/*     */       public ByReference() {
/* 249 */         super(4);
/* 250 */         getPointer().setInt(0L, -1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference(HighLevelMonitorConfigurationAPI.MC_DISPLAY_TECHNOLOGY_TYPE param2MC_DISPLAY_TECHNOLOGY_TYPE) {
/* 258 */         super(4);
/* 259 */         setValue(param2MC_DISPLAY_TECHNOLOGY_TYPE);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setValue(HighLevelMonitorConfigurationAPI.MC_DISPLAY_TECHNOLOGY_TYPE param2MC_DISPLAY_TECHNOLOGY_TYPE) {
/* 267 */         getPointer().setInt(0L, EnumUtils.toInteger(param2MC_DISPLAY_TECHNOLOGY_TYPE));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public HighLevelMonitorConfigurationAPI.MC_DISPLAY_TECHNOLOGY_TYPE getValue() {
/* 275 */         return (HighLevelMonitorConfigurationAPI.MC_DISPLAY_TECHNOLOGY_TYPE)EnumUtils.fromInteger(getPointer().getInt(0L), HighLevelMonitorConfigurationAPI.MC_DISPLAY_TECHNOLOGY_TYPE.class);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_DRIVE_TYPE
/*     */   {
/* 288 */     MC_RED_DRIVE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 293 */     MC_GREEN_DRIVE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     MC_BLUE_DRIVE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_GAIN_TYPE
/*     */   {
/* 309 */     MC_RED_GAIN,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     MC_GREEN_GAIN,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     MC_BLUE_GAIN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_POSITION_TYPE
/*     */   {
/* 330 */     MC_HORIZONTAL_POSITION,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 335 */     MC_VERTICAL_POSITION;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_SIZE_TYPE
/*     */   {
/* 347 */     MC_WIDTH,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 352 */     MC_HEIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum MC_COLOR_TEMPERATURE
/*     */   {
/* 364 */     MC_COLOR_TEMPERATURE_UNKNOWN,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 369 */     MC_COLOR_TEMPERATURE_4000K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 374 */     MC_COLOR_TEMPERATURE_5000K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 379 */     MC_COLOR_TEMPERATURE_6500K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 384 */     MC_COLOR_TEMPERATURE_7500K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     MC_COLOR_TEMPERATURE_8200K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 394 */     MC_COLOR_TEMPERATURE_9300K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 399 */     MC_COLOR_TEMPERATURE_10000K,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 404 */     MC_COLOR_TEMPERATURE_11500K;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends com.sun.jna.ptr.ByReference
/*     */     {
/*     */       public ByReference() {
/* 415 */         super(4);
/* 416 */         getPointer().setInt(0L, -1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference(HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE param2MC_COLOR_TEMPERATURE) {
/* 424 */         super(4);
/* 425 */         setValue(param2MC_COLOR_TEMPERATURE);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setValue(HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE param2MC_COLOR_TEMPERATURE) {
/* 433 */         getPointer().setInt(0L, EnumUtils.toInteger(param2MC_COLOR_TEMPERATURE));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE getValue() {
/* 441 */         return (HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE)EnumUtils.fromInteger(getPointer().getInt(0L), HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE.class);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\HighLevelMonitorConfigurationAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */