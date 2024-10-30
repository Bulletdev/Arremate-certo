/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.GraphicsCard;
/*     */ import oshi.hardware.common.AbstractGraphicsCard;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ @Immutable
/*     */ final class LinuxGraphicsCard
/*     */   extends AbstractGraphicsCard
/*     */ {
/*     */   LinuxGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  58 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
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
/*     */   public static List<GraphicsCard> getGraphicsCards() {
/*  70 */     List<GraphicsCard> list = getGraphicsCardsFromLspci();
/*  71 */     if (list.isEmpty()) {
/*  72 */       list = getGraphicsCardsFromLshw();
/*     */     }
/*  74 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<GraphicsCard> getGraphicsCardsFromLspci() {
/*  79 */     ArrayList<LinuxGraphicsCard> arrayList = new ArrayList();
/*     */     
/*  81 */     List list = ExecutingCommand.runNative("lspci -vnnm");
/*  82 */     String str1 = "unknown";
/*  83 */     String str2 = "unknown";
/*  84 */     String str3 = "unknown";
/*  85 */     ArrayList<? extends CharSequence> arrayList1 = new ArrayList();
/*  86 */     boolean bool = false;
/*  87 */     String str4 = null;
/*  88 */     for (String str5 : list) {
/*  89 */       String[] arrayOfString = str5.trim().split(":", 2);
/*  90 */       String str6 = arrayOfString[0];
/*     */       
/*  92 */       if (str6.equals("Class") && str5.contains("VGA")) {
/*  93 */         bool = true;
/*  94 */       } else if (str6.equals("Device") && !bool && arrayOfString.length > 1) {
/*  95 */         str4 = arrayOfString[1].trim();
/*     */       } 
/*  97 */       if (bool) {
/*  98 */         if (arrayOfString.length < 2) {
/*     */           
/* 100 */           arrayList.add(new LinuxGraphicsCard(str1, str2, str3, 
/* 101 */                 arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), 
/* 102 */                 queryLspciMemorySize(str4)));
/* 103 */           arrayList1.clear();
/* 104 */           bool = false; continue;
/*     */         } 
/* 106 */         if (str6.equals("Device")) {
/* 107 */           Pair pair = ParseUtil.parseLspciMachineReadable(arrayOfString[1].trim());
/* 108 */           if (pair != null) {
/* 109 */             str1 = (String)pair.getA();
/* 110 */             str2 = "0x" + (String)pair.getB();
/*     */           }  continue;
/* 112 */         }  if (str6.equals("Vendor")) {
/* 113 */           Pair pair = ParseUtil.parseLspciMachineReadable(arrayOfString[1].trim());
/* 114 */           if (pair != null) {
/* 115 */             str3 = (String)pair.getA() + " (0x" + (String)pair.getB() + ")"; continue;
/*     */           } 
/* 117 */           str3 = arrayOfString[1].trim(); continue;
/*     */         } 
/* 119 */         if (str6.equals("Rev:")) {
/* 120 */           arrayList1.add(str5.trim());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 126 */     if (bool) {
/* 127 */       arrayList.add(new LinuxGraphicsCard(str1, str2, str3, 
/* 128 */             arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), 
/* 129 */             queryLspciMemorySize(str4)));
/*     */     }
/* 131 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static long queryLspciMemorySize(String paramString) {
/* 135 */     long l = 0L;
/*     */ 
/*     */     
/* 138 */     List list = ExecutingCommand.runNative("lspci -v -s " + paramString);
/* 139 */     for (String str : list) {
/* 140 */       if (str.contains(" prefetchable")) {
/* 141 */         l += ParseUtil.parseLspciMemorySize(str);
/*     */       }
/*     */     } 
/* 144 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<GraphicsCard> getGraphicsCardsFromLshw() {
/* 149 */     ArrayList<LinuxGraphicsCard> arrayList = new ArrayList();
/* 150 */     List list = ExecutingCommand.runNative("lshw -C display");
/* 151 */     String str1 = "unknown";
/* 152 */     String str2 = "unknown";
/* 153 */     String str3 = "unknown";
/* 154 */     ArrayList<? extends CharSequence> arrayList1 = new ArrayList();
/* 155 */     long l = 0L;
/* 156 */     byte b = 0;
/* 157 */     for (String str : list) {
/* 158 */       String[] arrayOfString = str.trim().split(":");
/* 159 */       if (arrayOfString[0].startsWith("*-display")) {
/*     */         
/* 161 */         if (b++ > 0) {
/* 162 */           arrayList.add(new LinuxGraphicsCard(str1, str2, str3, 
/* 163 */                 arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), l));
/* 164 */           arrayList1.clear();
/*     */         }  continue;
/* 166 */       }  if (arrayOfString.length == 2) {
/* 167 */         String str4 = arrayOfString[0];
/* 168 */         if (str4.equals("product")) {
/* 169 */           str1 = arrayOfString[1].trim(); continue;
/* 170 */         }  if (str4.equals("vendor")) {
/* 171 */           str3 = arrayOfString[1].trim(); continue;
/* 172 */         }  if (str4.equals("version")) {
/* 173 */           arrayList1.add(str.trim()); continue;
/* 174 */         }  if (str4.startsWith("resources")) {
/* 175 */           l = ParseUtil.parseLshwResourceString(arrayOfString[1].trim());
/*     */         }
/*     */       } 
/*     */     } 
/* 179 */     arrayList.add(new LinuxGraphicsCard(str1, str2, str3, 
/* 180 */           arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), l));
/* 181 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */