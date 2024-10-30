/*     */ package org.apache.commons.net.util;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class SubnetUtils
/*     */ {
/*     */   private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
/*     */   private static final String SLASH_FORMAT = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,2})";
/*  31 */   private static final Pattern addressPattern = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
/*  32 */   private static final Pattern cidrPattern = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,2})");
/*     */ 
/*     */   
/*     */   private static final int NBITS = 32;
/*     */ 
/*     */   
/*     */   private static final String PARSE_FAIL = "Could not parse [%s]";
/*     */ 
/*     */   
/*     */   private final int netmask;
/*     */   
/*     */   private final int address;
/*     */   
/*     */   private final int network;
/*     */   
/*     */   private final int broadcast;
/*     */   
/*     */   private boolean inclusiveHostCount;
/*     */ 
/*     */   
/*     */   public SubnetUtils(String paramString) {
/*  53 */     Matcher matcher = cidrPattern.matcher(paramString);
/*     */     
/*  55 */     if (matcher.matches()) {
/*  56 */       this.address = matchAddress(matcher);
/*     */ 
/*     */ 
/*     */       
/*  60 */       int i = 32 - rangeCheck(Integer.parseInt(matcher.group(5)), 0, 32);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  69 */       this.netmask = (int)(4294967295L << i);
/*     */ 
/*     */       
/*  72 */       this.network = this.address & this.netmask;
/*     */ 
/*     */       
/*  75 */       this.broadcast = this.network | this.netmask ^ 0xFFFFFFFF;
/*     */     } else {
/*  77 */       throw new IllegalArgumentException(String.format("Could not parse [%s]", new Object[] { paramString }));
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
/*     */   public SubnetUtils(String paramString1, String paramString2) {
/*  89 */     this.address = toInteger(paramString1);
/*  90 */     this.netmask = toInteger(paramString2);
/*     */     
/*  92 */     if ((this.netmask & -this.netmask) - 1 != (this.netmask ^ 0xFFFFFFFF)) {
/*  93 */       throw new IllegalArgumentException(String.format("Could not parse [%s]", new Object[] { paramString2 }));
/*     */     }
/*     */ 
/*     */     
/*  97 */     this.network = this.address & this.netmask;
/*     */ 
/*     */     
/* 100 */     this.broadcast = this.network | this.netmask ^ 0xFFFFFFFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInclusiveHostCount() {
/* 111 */     return this.inclusiveHostCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInclusiveHostCount(boolean paramBoolean) {
/* 122 */     this.inclusiveHostCount = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final class SubnetInfo
/*     */   {
/*     */     private static final long UNSIGNED_INT_MASK = 4294967295L;
/*     */ 
/*     */ 
/*     */     
/*     */     private SubnetInfo() {}
/*     */ 
/*     */ 
/*     */     
/*     */     private long networkLong() {
/* 138 */       return SubnetUtils.this.network & 0xFFFFFFFFL; } private long broadcastLong() {
/* 139 */       return SubnetUtils.this.broadcast & 0xFFFFFFFFL;
/*     */     }
/*     */     private int low() {
/* 142 */       return SubnetUtils.this.isInclusiveHostCount() ? SubnetUtils.this.network : (
/* 143 */         (broadcastLong() - networkLong() > 1L) ? (SubnetUtils.this.network + 1) : 0);
/*     */     }
/*     */     
/*     */     private int high() {
/* 147 */       return SubnetUtils.this.isInclusiveHostCount() ? SubnetUtils.this.broadcast : (
/* 148 */         (broadcastLong() - networkLong() > 1L) ? (SubnetUtils.this.broadcast - 1) : 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInRange(String param1String) {
/* 160 */       return isInRange(SubnetUtils.toInteger(param1String));
/*     */     }
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
/*     */     public boolean isInRange(int param1Int) {
/* 173 */       if (param1Int == 0) {
/* 174 */         return false;
/*     */       }
/* 176 */       long l1 = param1Int & 0xFFFFFFFFL;
/* 177 */       long l2 = low() & 0xFFFFFFFFL;
/* 178 */       long l3 = high() & 0xFFFFFFFFL;
/* 179 */       return (l1 >= l2 && l1 <= l3);
/*     */     }
/*     */     
/*     */     public String getBroadcastAddress() {
/* 183 */       return format(toArray(SubnetUtils.this.broadcast));
/*     */     }
/*     */     
/*     */     public String getNetworkAddress() {
/* 187 */       return format(toArray(SubnetUtils.this.network));
/*     */     }
/*     */     
/*     */     public String getNetmask() {
/* 191 */       return format(toArray(SubnetUtils.this.netmask));
/*     */     }
/*     */     
/*     */     public String getAddress() {
/* 195 */       return format(toArray(SubnetUtils.this.address));
/*     */     }
/*     */     
/*     */     public String getNextAddress() {
/* 199 */       return format(toArray(SubnetUtils.this.address + 1));
/*     */     }
/*     */     
/*     */     public String getPreviousAddress() {
/* 203 */       return format(toArray(SubnetUtils.this.address - 1));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getLowAddress() {
/* 213 */       return format(toArray(low()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getHighAddress() {
/* 223 */       return format(toArray(high()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public int getAddressCount() {
/* 235 */       long l = getAddressCountLong();
/* 236 */       if (l > 2147483647L) {
/* 237 */         throw new RuntimeException("Count is larger than an integer: " + l);
/*     */       }
/*     */       
/* 240 */       return (int)l;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getAddressCountLong() {
/* 250 */       long l1 = broadcastLong();
/* 251 */       long l2 = networkLong();
/* 252 */       long l3 = l1 - l2 + (SubnetUtils.this.isInclusiveHostCount() ? 1L : -1L);
/* 253 */       return (l3 < 0L) ? 0L : l3;
/*     */     }
/*     */     
/*     */     public int asInteger(String param1String) {
/* 257 */       return SubnetUtils.toInteger(param1String);
/*     */     }
/*     */     
/*     */     public String getCidrSignature() {
/* 261 */       return format(toArray(SubnetUtils.this.address)) + "/" + SubnetUtils.this.pop(SubnetUtils.this.netmask);
/*     */     }
/*     */     
/*     */     public String[] getAllAddresses() {
/* 265 */       int i = getAddressCount();
/* 266 */       String[] arrayOfString = new String[i];
/* 267 */       if (i == 0)
/* 268 */         return arrayOfString;  int j;
/*     */       byte b;
/* 270 */       for (j = low(), b = 0; j <= high(); j++, b++) {
/* 271 */         arrayOfString[b] = format(toArray(j));
/*     */       }
/* 273 */       return arrayOfString;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int[] toArray(int param1Int) {
/* 280 */       int[] arrayOfInt = new int[4];
/* 281 */       for (byte b = 3; b >= 0; b--) {
/* 282 */         arrayOfInt[b] = arrayOfInt[b] | param1Int >>> 8 * (3 - b) & 0xFF;
/*     */       }
/* 284 */       return arrayOfInt;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String format(int[] param1ArrayOfint) {
/* 291 */       StringBuilder stringBuilder = new StringBuilder();
/* 292 */       for (byte b = 0; b < param1ArrayOfint.length; b++) {
/* 293 */         stringBuilder.append(param1ArrayOfint[b]);
/* 294 */         if (b != param1ArrayOfint.length - 1) {
/* 295 */           stringBuilder.append(".");
/*     */         }
/*     */       } 
/* 298 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 307 */       StringBuilder stringBuilder = new StringBuilder();
/* 308 */       stringBuilder.append("CIDR Signature:\t[").append(getCidrSignature()).append("]")
/* 309 */         .append(" Netmask: [").append(getNetmask()).append("]\n")
/* 310 */         .append("Network:\t[").append(getNetworkAddress()).append("]\n")
/* 311 */         .append("Broadcast:\t[").append(getBroadcastAddress()).append("]\n")
/* 312 */         .append("First Address:\t[").append(getLowAddress()).append("]\n")
/* 313 */         .append("Last Address:\t[").append(getHighAddress()).append("]\n")
/* 314 */         .append("# Addresses:\t[").append(getAddressCount()).append("]\n");
/* 315 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SubnetInfo getInfo() {
/* 323 */     return new SubnetInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int toInteger(String paramString) {
/* 329 */     Matcher matcher = addressPattern.matcher(paramString);
/* 330 */     if (matcher.matches()) {
/* 331 */       return matchAddress(matcher);
/*     */     }
/* 333 */     throw new IllegalArgumentException(String.format("Could not parse [%s]", new Object[] { paramString }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int matchAddress(Matcher paramMatcher) {
/* 341 */     int i = 0;
/* 342 */     for (byte b = 1; b <= 4; b++) {
/* 343 */       int j = rangeCheck(Integer.parseInt(paramMatcher.group(b)), 0, 255);
/* 344 */       i |= (j & 0xFF) << 8 * (4 - b);
/*     */     } 
/* 346 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int rangeCheck(int paramInt1, int paramInt2, int paramInt3) {
/* 355 */     if (paramInt1 >= paramInt2 && paramInt1 <= paramInt3) {
/* 356 */       return paramInt1;
/*     */     }
/*     */     
/* 359 */     throw new IllegalArgumentException("Value [" + paramInt1 + "] not in range [" + paramInt2 + "," + paramInt3 + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int pop(int paramInt) {
/* 367 */     paramInt -= paramInt >>> 1 & 0x55555555;
/* 368 */     paramInt = (paramInt & 0x33333333) + (paramInt >>> 2 & 0x33333333);
/* 369 */     paramInt = paramInt + (paramInt >>> 4) & 0xF0F0F0F;
/* 370 */     paramInt += paramInt >>> 8;
/* 371 */     paramInt += paramInt >>> 16;
/* 372 */     return paramInt & 0x3F;
/*     */   }
/*     */   
/*     */   public SubnetUtils getNext() {
/* 376 */     return new SubnetUtils(getInfo().getNextAddress(), getInfo().getNetmask());
/*     */   }
/*     */   
/*     */   public SubnetUtils getPrevious() {
/* 380 */     return new SubnetUtils(getInfo().getPreviousAddress(), getInfo().getNetmask());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\SubnetUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */