/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import com.sun.jna.win32.W32APIOptions;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Crypt32
/*    */   extends StdCallLibrary
/*    */ {
/* 44 */   public static final Crypt32 INSTANCE = (Crypt32)Native.load("Crypt32", Crypt32.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   
/*    */   boolean CryptProtectData(WinCrypt.DATA_BLOB paramDATA_BLOB1, String paramString, WinCrypt.DATA_BLOB paramDATA_BLOB2, Pointer paramPointer, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT, int paramInt, WinCrypt.DATA_BLOB paramDATA_BLOB3);
/*    */   
/*    */   boolean CryptUnprotectData(WinCrypt.DATA_BLOB paramDATA_BLOB1, PointerByReference paramPointerByReference, WinCrypt.DATA_BLOB paramDATA_BLOB2, Pointer paramPointer, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT, int paramInt, WinCrypt.DATA_BLOB paramDATA_BLOB3);
/*    */   
/*    */   boolean CertAddEncodedCertificateToSystemStore(String paramString, Pointer paramPointer, int paramInt);
/*    */   
/*    */   WinCrypt.HCERTSTORE CertOpenSystemStore(Pointer paramPointer, String paramString);
/*    */   
/*    */   boolean CryptSignMessage(WinCrypt.CRYPT_SIGN_MESSAGE_PARA paramCRYPT_SIGN_MESSAGE_PARA, boolean paramBoolean, int paramInt, Pointer[] paramArrayOfPointer, int[] paramArrayOfint, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   boolean CryptVerifyMessageSignature(WinCrypt.CRYPT_VERIFY_MESSAGE_PARA paramCRYPT_VERIFY_MESSAGE_PARA, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, IntByReference paramIntByReference, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean CertGetCertificateChain(WinCrypt.HCERTCHAINENGINE paramHCERTCHAINENGINE, WinCrypt.CERT_CONTEXT paramCERT_CONTEXT, WinBase.FILETIME paramFILETIME, WinCrypt.HCERTSTORE paramHCERTSTORE, WinCrypt.CERT_CHAIN_PARA paramCERT_CHAIN_PARA, int paramInt, Pointer paramPointer, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean CertFreeCertificateContext(WinCrypt.CERT_CONTEXT paramCERT_CONTEXT);
/*    */   
/*    */   void CertFreeCertificateChain(WinCrypt.CERT_CHAIN_CONTEXT paramCERT_CHAIN_CONTEXT);
/*    */   
/*    */   boolean CertCloseStore(WinCrypt.HCERTSTORE paramHCERTSTORE, int paramInt);
/*    */   
/*    */   int CertNameToStr(int paramInt1, WinCrypt.DATA_BLOB paramDATA_BLOB, int paramInt2, Pointer paramPointer, int paramInt3);
/*    */   
/*    */   boolean CertVerifyCertificateChainPolicy(WTypes.LPSTR paramLPSTR, WinCrypt.CERT_CHAIN_CONTEXT paramCERT_CHAIN_CONTEXT, WinCrypt.CERT_CHAIN_POLICY_PARA paramCERT_CHAIN_POLICY_PARA, WinCrypt.CERT_CHAIN_POLICY_STATUS paramCERT_CHAIN_POLICY_STATUS);
/*    */   
/*    */   WinCrypt.CERT_CONTEXT.ByReference CertFindCertificateInStore(WinCrypt.HCERTSTORE paramHCERTSTORE, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, WinCrypt.CERT_CONTEXT paramCERT_CONTEXT);
/*    */   
/*    */   WinCrypt.HCERTSTORE PFXImportCertStore(WinCrypt.DATA_BLOB paramDATA_BLOB, WTypes.LPWSTR paramLPWSTR, int paramInt);
/*    */   
/*    */   WinCrypt.CERT_CONTEXT.ByReference CertEnumCertificatesInStore(WinCrypt.HCERTSTORE paramHCERTSTORE, Pointer paramPointer);
/*    */   
/*    */   WinCrypt.CTL_CONTEXT.ByReference CertEnumCTLsInStore(WinCrypt.HCERTSTORE paramHCERTSTORE, Pointer paramPointer);
/*    */   
/*    */   WinCrypt.CRL_CONTEXT.ByReference CertEnumCRLsInStore(WinCrypt.HCERTSTORE paramHCERTSTORE, Pointer paramPointer);
/*    */   
/*    */   boolean CryptQueryObject(int paramInt1, Pointer paramPointer, int paramInt2, int paramInt3, int paramInt4, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, PointerByReference paramPointerByReference1, PointerByReference paramPointerByReference2, PointerByReference paramPointerByReference3);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Crypt32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */