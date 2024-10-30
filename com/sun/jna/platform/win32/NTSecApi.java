/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.Union;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface NTSecApi
/*     */ {
/*     */   public static final int ForestTrustTopLevelName = 0;
/*     */   public static final int ForestTrustTopLevelNameEx = 1;
/*     */   public static final int ForestTrustDomainInfo = 2;
/*     */   
/*     */   @FieldOrder({"Length", "MaximumLength", "Buffer"})
/*     */   public static class LSA_UNICODE_STRING
/*     */     extends Structure
/*     */   {
/*     */     public short Length;
/*     */     public short MaximumLength;
/*     */     public Pointer Buffer;
/*     */     
/*     */     public static class ByReference
/*     */       extends LSA_UNICODE_STRING
/*     */       implements Structure.ByReference {}
/*     */     
/*     */     public String getString() {
/*  75 */       byte[] arrayOfByte = this.Buffer.getByteArray(0L, this.Length);
/*  76 */       if (arrayOfByte.length < 2 || arrayOfByte[arrayOfByte.length - 1] != 0) {
/*  77 */         Memory memory = new Memory((arrayOfByte.length + 2));
/*  78 */         memory.write(0L, arrayOfByte, 0, arrayOfByte.length);
/*  79 */         return memory.getWideString(0L);
/*     */       } 
/*  81 */       return this.Buffer.getWideString(0L);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PLSA_UNICODE_STRING
/*     */   {
/*     */     public NTSecApi.LSA_UNICODE_STRING.ByReference s;
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends PLSA_UNICODE_STRING
/*     */       implements Structure.ByReference {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"Sid", "DnsName", "NetbiosName"})
/*     */   public static class LSA_FOREST_TRUST_DOMAIN_INFO
/*     */     extends Structure
/*     */   {
/*     */     public WinNT.PSID.ByReference Sid;
/*     */ 
/*     */     
/*     */     public NTSecApi.LSA_UNICODE_STRING DnsName;
/*     */ 
/*     */     
/*     */     public NTSecApi.LSA_UNICODE_STRING NetbiosName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"Length", "Buffer"})
/*     */   public static class LSA_FOREST_TRUST_BINARY_DATA
/*     */     extends Structure
/*     */   {
/*     */     public int Length;
/*     */ 
/*     */     
/*     */     public Pointer Buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"Flags", "ForestTrustType", "Time", "u"})
/*     */   public static class LSA_FOREST_TRUST_RECORD
/*     */     extends Structure
/*     */   {
/*     */     public int Flags;
/*     */ 
/*     */     
/*     */     public int ForestTrustType;
/*     */ 
/*     */     
/*     */     public WinNT.LARGE_INTEGER Time;
/*     */ 
/*     */     
/*     */     public UNION u;
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends LSA_FOREST_TRUST_RECORD
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */     
/*     */     public static class UNION
/*     */       extends Union
/*     */     {
/*     */       public NTSecApi.LSA_UNICODE_STRING TopLevelName;
/*     */       
/*     */       public NTSecApi.LSA_FOREST_TRUST_DOMAIN_INFO DomainInfo;
/*     */       
/*     */       public NTSecApi.LSA_FOREST_TRUST_BINARY_DATA Data;
/*     */ 
/*     */       
/*     */       public static class ByReference
/*     */         extends UNION
/*     */         implements Structure.ByReference {}
/*     */     }
/*     */ 
/*     */     
/*     */     public void read() {
/* 167 */       super.read();
/*     */       
/* 169 */       switch (this.ForestTrustType) {
/*     */         case 0:
/*     */         case 1:
/* 172 */           this.u.setType(NTSecApi.LSA_UNICODE_STRING.class);
/*     */           break;
/*     */         case 2:
/* 175 */           this.u.setType(NTSecApi.LSA_FOREST_TRUST_DOMAIN_INFO.class);
/*     */           break;
/*     */         default:
/* 178 */           this.u.setType(NTSecApi.LSA_FOREST_TRUST_BINARY_DATA.class);
/*     */           break;
/*     */       } 
/*     */       
/* 182 */       this.u.read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"tr"})
/*     */   public static class PLSA_FOREST_TRUST_RECORD
/*     */     extends Structure
/*     */   {
/*     */     public NTSecApi.LSA_FOREST_TRUST_RECORD.ByReference tr;
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends PLSA_FOREST_TRUST_RECORD
/*     */       implements Structure.ByReference {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"RecordCount", "Entries"})
/*     */   public static class LSA_FOREST_TRUST_INFORMATION
/*     */     extends Structure
/*     */   {
/*     */     public int RecordCount;
/*     */ 
/*     */     
/*     */     public NTSecApi.PLSA_FOREST_TRUST_RECORD.ByReference Entries;
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends LSA_FOREST_TRUST_INFORMATION
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */     
/*     */     public NTSecApi.PLSA_FOREST_TRUST_RECORD[] getEntries() {
/* 220 */       return (NTSecApi.PLSA_FOREST_TRUST_RECORD[])this.Entries.toArray(this.RecordCount);
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"fti"})
/*     */   public static class PLSA_FOREST_TRUST_INFORMATION extends Structure {
/*     */     public NTSecApi.LSA_FOREST_TRUST_INFORMATION.ByReference fti;
/*     */     
/*     */     public static class ByReference extends PLSA_FOREST_TRUST_INFORMATION implements Structure.ByReference {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\NTSecApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */