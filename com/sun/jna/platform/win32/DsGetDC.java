/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.win32.W32APITypeMapper;
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
/*     */ public interface DsGetDC
/*     */ {
/*     */   public static final int DS_DOMAIN_IN_FOREST = 1;
/*     */   public static final int DS_DOMAIN_DIRECT_OUTBOUND = 2;
/*     */   public static final int DS_DOMAIN_TREE_ROOT = 4;
/*     */   public static final int DS_DOMAIN_PRIMARY = 8;
/*     */   public static final int DS_DOMAIN_NATIVE_MODE = 16;
/*     */   public static final int DS_DOMAIN_DIRECT_INBOUND = 32;
/*     */   public static final int DS_DOMAIN_VALID_FLAGS = 63;
/*     */   
/*     */   @FieldOrder({"DomainControllerName", "DomainControllerAddress", "DomainControllerAddressType", "DomainGuid", "DomainName", "DnsForestName", "Flags", "DcSiteName", "ClientSiteName"})
/*     */   public static class DOMAIN_CONTROLLER_INFO
/*     */     extends Structure
/*     */   {
/*     */     public String DomainControllerName;
/*     */     public String DomainControllerAddress;
/*     */     public int DomainControllerAddressType;
/*     */     public Guid.GUID DomainGuid;
/*     */     public String DomainName;
/*     */     public String DnsForestName;
/*     */     public int Flags;
/*     */     public String DcSiteName;
/*     */     public String ClientSiteName;
/*     */     
/*     */     public static class ByReference
/*     */       extends DOMAIN_CONTROLLER_INFO
/*     */       implements Structure.ByReference {}
/*     */     
/*     */     public DOMAIN_CONTROLLER_INFO() {
/* 122 */       super(W32APITypeMapper.DEFAULT);
/*     */     }
/*     */     
/*     */     public DOMAIN_CONTROLLER_INFO(Pointer param1Pointer) {
/* 126 */       super(param1Pointer, 0, W32APITypeMapper.DEFAULT);
/* 127 */       read();
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
/*     */   @FieldOrder({"dci"})
/*     */   public static class PDOMAIN_CONTROLLER_INFO
/*     */     extends Structure
/*     */   {
/*     */     public DsGetDC.DOMAIN_CONTROLLER_INFO.ByReference dci;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends PDOMAIN_CONTROLLER_INFO
/*     */       implements Structure.ByReference {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"NetbiosDomainName", "DnsDomainName", "Flags", "ParentIndex", "TrustType", "TrustAttributes", "DomainSid", "DomainGuid"})
/*     */   public static class DS_DOMAIN_TRUSTS
/*     */     extends Structure
/*     */   {
/*     */     public String NetbiosDomainName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String DnsDomainName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int Flags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int ParentIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int TrustType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int TrustAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.PSID.ByReference DomainSid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Guid.GUID DomainGuid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends DS_DOMAIN_TRUSTS
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DS_DOMAIN_TRUSTS() {
/* 233 */       super(W32APITypeMapper.DEFAULT);
/*     */     }
/*     */     
/*     */     public DS_DOMAIN_TRUSTS(Pointer param1Pointer) {
/* 237 */       super(param1Pointer, 0, W32APITypeMapper.DEFAULT);
/* 238 */       read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\DsGetDC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */