/*     */ package org.apache.poi.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackageAccess;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
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
/*     */ public class OOXMLLister
/*     */ {
/*     */   private final OPCPackage container;
/*     */   private final PrintStream disp;
/*     */   
/*     */   public OOXMLLister(OPCPackage paramOPCPackage) {
/*  42 */     this(paramOPCPackage, System.out);
/*     */   }
/*     */   public OOXMLLister(OPCPackage paramOPCPackage, PrintStream paramPrintStream) {
/*  45 */     this.container = paramOPCPackage;
/*  46 */     this.disp = paramPrintStream;
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
/*     */   public static long getSize(PackagePart paramPackagePart) throws IOException {
/*  58 */     InputStream inputStream = paramPackagePart.getInputStream();
/*     */     try {
/*  60 */       byte[] arrayOfByte = new byte[8192];
/*  61 */       long l = 0L;
/*  62 */       int i = 0;
/*     */       
/*  64 */       while (i > -1) {
/*  65 */         i = inputStream.read(arrayOfByte);
/*  66 */         if (i > 0) {
/*  67 */           l += i;
/*     */         }
/*     */       } 
/*     */       
/*  71 */       return l;
/*     */     } finally {
/*  73 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void displayParts() throws InvalidFormatException, IOException {
/*  84 */     ArrayList arrayList = this.container.getParts();
/*  85 */     for (PackagePart packagePart : arrayList) {
/*  86 */       this.disp.println(packagePart.getPartName());
/*  87 */       this.disp.println("\t" + packagePart.getContentType());
/*     */       
/*  89 */       if (!packagePart.getPartName().toString().equals("/docProps/core.xml")) {
/*  90 */         this.disp.println("\t" + getSize(packagePart) + " bytes");
/*     */       }
/*     */       
/*  93 */       if (!packagePart.isRelationshipPart()) {
/*  94 */         this.disp.println("\t" + packagePart.getRelationships().size() + " relations");
/*  95 */         for (PackageRelationship packageRelationship : packagePart.getRelationships()) {
/*  96 */           displayRelation(packageRelationship, "\t  ");
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void displayRelations() {
/* 107 */     PackageRelationshipCollection packageRelationshipCollection = this.container.getRelationships();
/*     */     
/* 109 */     for (PackageRelationship packageRelationship : packageRelationshipCollection)
/* 110 */       displayRelation(packageRelationship, ""); 
/*     */   }
/*     */   
/*     */   private void displayRelation(PackageRelationship paramPackageRelationship, String paramString) {
/* 114 */     this.disp.println(paramString + "Relationship:");
/* 115 */     this.disp.println(paramString + "\tFrom: " + paramPackageRelationship.getSourceURI());
/* 116 */     this.disp.println(paramString + "\tTo:   " + paramPackageRelationship.getTargetURI());
/* 117 */     this.disp.println(paramString + "\tID:   " + paramPackageRelationship.getId());
/* 118 */     this.disp.println(paramString + "\tMode: " + paramPackageRelationship.getTargetMode());
/* 119 */     this.disp.println(paramString + "\tType: " + paramPackageRelationship.getRelationshipType());
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/* 123 */     if (paramArrayOfString.length == 0) {
/* 124 */       System.err.println("Use:");
/* 125 */       System.err.println("\tjava OOXMLLister <filename>");
/* 126 */       System.exit(1);
/*     */     } 
/*     */     
/* 129 */     File file = new File(paramArrayOfString[0]);
/* 130 */     if (!file.exists()) {
/* 131 */       System.err.println("Error, file not found!");
/* 132 */       System.err.println("\t" + file.toString());
/* 133 */       System.exit(2);
/*     */     } 
/*     */     
/* 136 */     OOXMLLister oOXMLLister = new OOXMLLister(OPCPackage.open(file.toString(), PackageAccess.READ));
/*     */ 
/*     */ 
/*     */     
/* 140 */     oOXMLLister.disp.println(file.toString() + "\n");
/* 141 */     oOXMLLister.displayParts();
/* 142 */     oOXMLLister.disp.println();
/* 143 */     oOXMLLister.displayRelations();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\dev\OOXMLLister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */