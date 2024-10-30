/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnknownRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final int PRINTSIZE_0033 = 51;
/*     */   public static final int PLS_004D = 77;
/*     */   public static final int SHEETPR_0081 = 129;
/*     */   public static final int SORT_0090 = 144;
/*     */   public static final int STANDARDWIDTH_0099 = 153;
/*     */   public static final int SCL_00A0 = 160;
/*     */   public static final int BITMAP_00E9 = 233;
/*     */   public static final int PHONETICPR_00EF = 239;
/*     */   public static final int LABELRANGES_015F = 351;
/*     */   public static final int QUICKTIP_0800 = 2048;
/*     */   public static final int SHEETEXT_0862 = 2146;
/*     */   public static final int SHEETPROTECTION_0867 = 2151;
/*     */   public static final int HEADER_FOOTER_089C = 2204;
/*     */   public static final int CODENAME_1BA = 442;
/*     */   public static final int PLV_MAC = 2248;
/*     */   private int _sid;
/*     */   private byte[] _rawData;
/*     */   
/*     */   public UnknownRecord(int paramInt, byte[] paramArrayOfbyte) {
/*  70 */     this._sid = paramInt & 0xFFFF;
/*  71 */     this._rawData = paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnknownRecord(RecordInputStream paramRecordInputStream) {
/*  81 */     this._sid = paramRecordInputStream.getSid();
/*  82 */     this._rawData = paramRecordInputStream.readRemainder();
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
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  97 */     paramLittleEndianOutput.write(this._rawData);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 102 */     return this._rawData.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 110 */     String str = getBiffName(this._sid);
/* 111 */     if (str == null) {
/* 112 */       str = "UNKNOWNRECORD";
/*     */     }
/* 114 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 116 */     stringBuffer.append("[").append(str).append("] (0x");
/* 117 */     stringBuffer.append(Integer.toHexString(this._sid).toUpperCase(Locale.ROOT) + ")\n");
/* 118 */     if (this._rawData.length > 0) {
/* 119 */       stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
/*     */     }
/* 121 */     stringBuffer.append("[/").append(str).append("]\n");
/* 122 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 127 */     return (short)this._sid;
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
/*     */   public static String getBiffName(int paramInt) {
/* 139 */     switch (paramInt) { case 51:
/* 140 */         return "PRINTSIZE";
/* 141 */       case 77: return "PLS";
/* 142 */       case 80: return "DCON";
/* 143 */       case 127: return "IMDATA";
/* 144 */       case 129: return "SHEETPR";
/* 145 */       case 144: return "SORT";
/* 146 */       case 148: return "LHRECORD";
/* 147 */       case 153: return "STANDARDWIDTH";
/* 148 */       case 160: return "SCL";
/* 149 */       case 174: return "SCENMAN";
/*     */       case 178:
/* 151 */         return "SXVI";
/* 152 */       case 180: return "SXIVD";
/* 153 */       case 181: return "SXLI";
/*     */       case 211:
/* 155 */         return "OBPROJ";
/* 156 */       case 220: return "PARAMQRY";
/* 157 */       case 222: return "OLESIZE";
/* 158 */       case 233: return "BITMAP";
/* 159 */       case 239: return "PHONETICPR";
/* 160 */       case 241: return "SXEX";
/*     */       case 351:
/* 162 */         return "LABELRANGES";
/* 163 */       case 442: return "CODENAME";
/* 164 */       case 425: return "USERBVIEW";
/* 165 */       case 429: return "QSI";
/*     */       case 448:
/* 167 */         return "EXCEL9FILE";
/*     */       case 2050:
/* 169 */         return "QSISXTAG";
/* 170 */       case 2051: return "DBQUERYEXT";
/* 171 */       case 2053: return "TXTQUERY";
/* 172 */       case 2064: return "SXVIEWEX9";
/*     */       case 2066:
/* 174 */         return "CONTINUEFRT";
/* 175 */       case 2048: return "QUICKTIP";
/* 176 */       case 2146: return "SHEETEXT";
/* 177 */       case 2147: return "BOOKEXT";
/* 178 */       case 2148: return "SXADDL";
/* 179 */       case 2151: return "SHEETPROTECTION";
/* 180 */       case 2155: return "DATALABEXTCONTENTS";
/* 181 */       case 2156: return "CELLWATCH";
/* 182 */       case 2162: return "SHARED FEATURE v11";
/* 183 */       case 2164: return "DROPDOWNOBJIDS";
/* 184 */       case 2166: return "DCONN";
/* 185 */       case 2168: return "SHARED FEATURE v12";
/* 186 */       case 2171: return "CFEX";
/* 187 */       case 2172: return "XFCRC";
/* 188 */       case 2173: return "XFEXT";
/* 189 */       case 2175: return "CONTINUEFRT12";
/* 190 */       case 2187: return "PLV";
/* 191 */       case 2188: return "COMPAT12";
/* 192 */       case 2189: return "DXF";
/* 193 */       case 2194: return "STYLEEXT";
/* 194 */       case 2198: return "THEME";
/* 195 */       case 2199: return "GUIDTYPELIB";
/* 196 */       case 2202: return "MTRSETTINGS";
/* 197 */       case 2203: return "COMPRESSPICTURES";
/* 198 */       case 2204: return "HEADERFOOTER";
/* 199 */       case 2205: return "CRTLAYOUT12";
/* 200 */       case 2206: return "CRTMLFRT";
/* 201 */       case 2207: return "CRTMLFRTCONTINUE";
/* 202 */       case 2209: return "SHAPEPROPSSTREAM";
/* 203 */       case 2211: return "FORCEFULLCALCULATION";
/* 204 */       case 2212: return "SHAPEPROPSSTREAM";
/* 205 */       case 2213: return "TEXTPROPSSTREAM";
/* 206 */       case 2214: return "RICHTEXTSTREAM";
/* 207 */       case 2215: return "CRTLAYOUT12A";
/*     */       case 2248:
/* 209 */         return "PLV{Mac Excel}";
/*     */       case 4097:
/* 211 */         return "UNITS";
/* 212 */       case 4102: return "CHARTDATAFORMAT";
/* 213 */       case 4103: return "CHARTLINEFORMAT"; }
/*     */     
/* 215 */     if (isObservedButUnknown(paramInt)) {
/* 216 */       return "UNKNOWN-" + Integer.toHexString(paramInt).toUpperCase(Locale.ROOT);
/*     */     }
/*     */     
/* 219 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isObservedButUnknown(int paramInt) {
/* 227 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 51:
/*     */       case 52:
/*     */       case 445:
/*     */       case 450:
/*     */       case 4105:
/*     */       case 4106:
/*     */       case 4107:
/*     */       case 4108:
/*     */       case 4116:
/*     */       case 4119:
/*     */       case 4120:
/*     */       case 4121:
/*     */       case 4122:
/*     */       case 4123:
/*     */       case 4125:
/*     */       case 4126:
/*     */       case 4127:
/*     */       case 4128:
/*     */       case 4129:
/*     */       case 4130:
/*     */       case 4132:
/*     */       case 4133:
/*     */       case 4134:
/*     */       case 4135:
/*     */       case 4146:
/*     */       case 4147:
/*     */       case 4148:
/*     */       case 4149:
/*     */       case 4154:
/*     */       case 4161:
/*     */       case 4163:
/*     */       case 4164:
/*     */       case 4165:
/*     */       case 4166:
/*     */       case 4170:
/*     */       case 4171:
/*     */       case 4174:
/*     */       case 4175:
/*     */       case 4177:
/*     */       case 4188:
/*     */       case 4189:
/*     */       case 4191:
/*     */       case 4192:
/*     */       case 4194:
/*     */       case 4195:
/*     */       case 4196:
/*     */       case 4197:
/*     */       case 4198:
/* 284 */         return true;
/*     */     } 
/* 286 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 292 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\UnknownRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */