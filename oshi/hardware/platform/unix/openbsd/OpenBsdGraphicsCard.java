/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.GraphicsCard;
/*     */ import oshi.hardware.common.AbstractGraphicsCard;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ final class OpenBsdGraphicsCard
/*     */   extends AbstractGraphicsCard
/*     */ {
/*     */   private static final String PCI_CLASS_DISPLAY = "Class: 03 Display";
/*  45 */   private static final Pattern PCI_DUMP_HEADER = Pattern.compile(" \\d+:\\d+:\\d+: (.+)");
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
/*     */   OpenBsdGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  62 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
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
/*     */   public static List<GraphicsCard> getGraphicsCards() {
/*  75 */     ArrayList<OpenBsdGraphicsCard> arrayList = new ArrayList();
/*     */     
/*  77 */     List list = ExecutingCommand.runNative("pcidump -v");
/*  78 */     if (list.isEmpty()) {
/*  79 */       return Collections.emptyList();
/*     */     }
/*  81 */     String str1 = "";
/*  82 */     String str2 = "";
/*  83 */     String str3 = "";
/*  84 */     boolean bool = false;
/*  85 */     String str4 = "";
/*  86 */     for (String str : list) {
/*  87 */       Matcher matcher = PCI_DUMP_HEADER.matcher(str);
/*  88 */       if (matcher.matches()) {
/*     */         
/*  90 */         if (bool) {
/*  91 */           arrayList.add(new OpenBsdGraphicsCard(str1.isEmpty() ? "unknown" : str1, 
/*  92 */                 str3.isEmpty() ? "0x0000" : str3, str2.isEmpty() ? "0x0000" : str2, 
/*  93 */                 str4.isEmpty() ? "unknown" : str4, 0L));
/*     */         }
/*     */         
/*  96 */         str1 = matcher.group(1);
/*     */         
/*  98 */         str2 = "";
/*  99 */         str3 = "";
/* 100 */         bool = false;
/* 101 */         str4 = "";
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */       
/* 108 */       if (!bool) {
/* 109 */         int i = str.indexOf("Vendor ID: ");
/* 110 */         if (i >= 0 && str.length() >= i + 15) {
/* 111 */           str2 = "0x" + str.substring(i + 11, i + 15);
/*     */         }
/* 113 */         i = str.indexOf("Product ID: ");
/* 114 */         if (i >= 0 && str.length() >= i + 16) {
/* 115 */           str3 = "0x" + str.substring(i + 12, i + 16);
/*     */         }
/* 117 */         if (str.contains("Class: 03 Display"))
/* 118 */           bool = true;  continue;
/*     */       } 
/* 120 */       if (str4.isEmpty()) {
/* 121 */         int i = str.indexOf("Revision: ");
/* 122 */         if (i >= 0) {
/* 123 */           str4 = str.substring(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     if (bool) {
/* 130 */       arrayList.add(new OpenBsdGraphicsCard(str1.isEmpty() ? "unknown" : str1, 
/* 131 */             str3.isEmpty() ? "0x0000" : str3, str2.isEmpty() ? "0x0000" : str2, 
/* 132 */             str4.isEmpty() ? "unknown" : str4, 0L));
/*     */     }
/* 134 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */