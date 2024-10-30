/*     */ package oshi.util;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Arrays;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
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
/*     */ @ThreadSafe
/*     */ public final class EdidUtil
/*     */ {
/*  42 */   private static final Logger LOG = LoggerFactory.getLogger(EdidUtil.class);
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
/*     */   public static String getManufacturerID(byte[] paramArrayOfbyte) {
/*  58 */     String str = String.format("%8s%8s", new Object[] { Integer.toBinaryString(paramArrayOfbyte[8] & 0xFF), Integer.toBinaryString(paramArrayOfbyte[9] & 0xFF) }).replace(' ', '0');
/*  59 */     LOG.debug("Manufacurer ID: {}", str);
/*  60 */     return String.format("%s%s%s", new Object[] { Character.valueOf((char)(64 + Integer.parseInt(str.substring(1, 6), 2))), 
/*  61 */           Character.valueOf((char)(64 + Integer.parseInt(str.substring(7, 11), 2))), 
/*  62 */           Character.valueOf((char)(64 + Integer.parseInt(str.substring(12, 16), 2))) }).replace("@", "");
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
/*     */   public static String getProductID(byte[] paramArrayOfbyte) {
/*  74 */     return Integer.toHexString(
/*  75 */         ByteBuffer.wrap(Arrays.copyOfRange(paramArrayOfbyte, 10, 12)).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFFF);
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
/*     */   public static String getSerialNo(byte[] paramArrayOfbyte) {
/*  88 */     if (LOG.isDebugEnabled()) {
/*  89 */       LOG.debug("Serial number: {}", Arrays.toString(Arrays.copyOfRange(paramArrayOfbyte, 12, 16)));
/*     */     }
/*  91 */     return String.format("%s%s%s%s", new Object[] { getAlphaNumericOrHex(paramArrayOfbyte[15]), getAlphaNumericOrHex(paramArrayOfbyte[14]), 
/*  92 */           getAlphaNumericOrHex(paramArrayOfbyte[13]), getAlphaNumericOrHex(paramArrayOfbyte[12]) });
/*     */   }
/*     */   
/*     */   private static String getAlphaNumericOrHex(byte paramByte) {
/*  96 */     return Character.isLetterOrDigit((char)paramByte) ? String.format("%s", new Object[] { Character.valueOf((char)paramByte) }) : String.format("%02X", new Object[] { Byte.valueOf(paramByte) });
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
/*     */   public static byte getWeek(byte[] paramArrayOfbyte) {
/* 108 */     return paramArrayOfbyte[16];
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
/*     */   public static int getYear(byte[] paramArrayOfbyte) {
/* 120 */     byte b = paramArrayOfbyte[17];
/* 121 */     LOG.debug("Year-1990: {}", Byte.valueOf(b));
/* 122 */     return b + 1990;
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
/*     */   public static String getVersion(byte[] paramArrayOfbyte) {
/* 134 */     return paramArrayOfbyte[18] + "." + paramArrayOfbyte[19];
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
/*     */   public static boolean isDigital(byte[] paramArrayOfbyte) {
/* 146 */     return (1 == (paramArrayOfbyte[20] & 0xFF) >> 7);
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
/*     */   public static int getHcm(byte[] paramArrayOfbyte) {
/* 158 */     return paramArrayOfbyte[21];
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
/*     */   public static int getVcm(byte[] paramArrayOfbyte) {
/* 170 */     return paramArrayOfbyte[22];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[][] getDescriptors(byte[] paramArrayOfbyte) {
/* 181 */     byte[][] arrayOfByte = new byte[4][18];
/* 182 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 183 */       System.arraycopy(paramArrayOfbyte, 54 + 18 * b, arrayOfByte[b], 0, 18);
/*     */     }
/* 185 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getDescriptorType(byte[] paramArrayOfbyte) {
/* 196 */     return ByteBuffer.wrap(Arrays.copyOfRange(paramArrayOfbyte, 0, 4)).getInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getTimingDescriptor(byte[] paramArrayOfbyte) {
/* 207 */     int i = ByteBuffer.wrap(Arrays.copyOfRange(paramArrayOfbyte, 0, 2)).order(ByteOrder.LITTLE_ENDIAN).getShort() / 100;
/* 208 */     int j = (paramArrayOfbyte[2] & 0xFF) + ((paramArrayOfbyte[4] & 0xF0) << 4);
/* 209 */     int k = (paramArrayOfbyte[5] & 0xFF) + ((paramArrayOfbyte[7] & 0xF0) << 4);
/* 210 */     return String.format("Clock %dMHz, Active Pixels %dx%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDescriptorRangeLimits(byte[] paramArrayOfbyte) {
/* 221 */     return String.format("Field Rate %d-%d Hz vertical, %d-%d Hz horizontal, Max clock: %d MHz", new Object[] { Byte.valueOf(paramArrayOfbyte[5]), Byte.valueOf(paramArrayOfbyte[6]), 
/* 222 */           Byte.valueOf(paramArrayOfbyte[7]), Byte.valueOf(paramArrayOfbyte[8]), Integer.valueOf(paramArrayOfbyte[9] * 10) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDescriptorText(byte[] paramArrayOfbyte) {
/* 233 */     return (new String(Arrays.copyOfRange(paramArrayOfbyte, 4, 18), StandardCharsets.US_ASCII)).trim();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(byte[] paramArrayOfbyte) {
/* 244 */     StringBuilder stringBuilder = new StringBuilder();
/* 245 */     stringBuilder.append("  Manuf. ID=").append(getManufacturerID(paramArrayOfbyte));
/* 246 */     stringBuilder.append(", Product ID=").append(getProductID(paramArrayOfbyte));
/* 247 */     stringBuilder.append(", ").append(isDigital(paramArrayOfbyte) ? "Digital" : "Analog");
/* 248 */     stringBuilder.append(", Serial=").append(getSerialNo(paramArrayOfbyte));
/* 249 */     stringBuilder.append(", ManufDate=").append(getWeek(paramArrayOfbyte) * 12 / 52 + 1).append('/')
/* 250 */       .append(getYear(paramArrayOfbyte));
/* 251 */     stringBuilder.append(", EDID v").append(getVersion(paramArrayOfbyte));
/* 252 */     int i = getHcm(paramArrayOfbyte);
/* 253 */     int j = getVcm(paramArrayOfbyte);
/* 254 */     stringBuilder.append(String.format("%n  %d x %d cm (%.1f x %.1f in)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(i / 2.54D), Double.valueOf(j / 2.54D) }));
/* 255 */     byte[][] arrayOfByte = getDescriptors(paramArrayOfbyte);
/* 256 */     for (byte[] arrayOfByte1 : arrayOfByte) {
/* 257 */       switch (getDescriptorType(arrayOfByte1)) {
/*     */         case 255:
/* 259 */           stringBuilder.append("\n  Serial Number: ").append(getDescriptorText(arrayOfByte1));
/*     */           break;
/*     */         case 254:
/* 262 */           stringBuilder.append("\n  Unspecified Text: ").append(getDescriptorText(arrayOfByte1));
/*     */           break;
/*     */         case 253:
/* 265 */           stringBuilder.append("\n  Range Limits: ").append(getDescriptorRangeLimits(arrayOfByte1));
/*     */           break;
/*     */         case 252:
/* 268 */           stringBuilder.append("\n  Monitor Name: ").append(getDescriptorText(arrayOfByte1));
/*     */           break;
/*     */         case 251:
/* 271 */           stringBuilder.append("\n  White Point Data: ").append(ParseUtil.byteArrayToHexString(arrayOfByte1));
/*     */           break;
/*     */         case 250:
/* 274 */           stringBuilder.append("\n  Standard Timing ID: ").append(ParseUtil.byteArrayToHexString(arrayOfByte1));
/*     */           break;
/*     */         default:
/* 277 */           if (getDescriptorType(arrayOfByte1) <= 15 && getDescriptorType(arrayOfByte1) >= 0) {
/* 278 */             stringBuilder.append("\n  Manufacturer Data: ").append(ParseUtil.byteArrayToHexString(arrayOfByte1)); break;
/*     */           } 
/* 280 */           stringBuilder.append("\n  Preferred Timing: ").append(getTimingDescriptor(arrayOfByte1));
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 285 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\EdidUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */