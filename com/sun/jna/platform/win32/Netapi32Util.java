/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Netapi32Util
/*     */ {
/*     */   public static class Group
/*     */   {
/*     */     public String name;
/*     */   }
/*     */   
/*     */   public static class User
/*     */   {
/*     */     public String name;
/*     */     public String comment;
/*     */   }
/*     */   
/*     */   public static class UserInfo
/*     */     extends User
/*     */   {
/*     */     public String fullName;
/*     */     public String sidString;
/*     */     public WinNT.PSID sid;
/*     */     public int flags;
/*     */   }
/*     */   
/*     */   public static class LocalGroup
/*     */     extends Group
/*     */   {
/*     */     public String comment;
/*     */   }
/*     */   
/*     */   public static String getDCName() {
/* 105 */     return getDCName(null, null);
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
/*     */   public static String getDCName(String paramString1, String paramString2) {
/* 119 */     PointerByReference pointerByReference = new PointerByReference();
/*     */     try {
/* 121 */       int i = Netapi32.INSTANCE.NetGetDCName(paramString2, paramString1, pointerByReference);
/* 122 */       if (0 != i) {
/* 123 */         throw new Win32Exception(i);
/*     */       }
/* 125 */       return pointerByReference.getValue().getWideString(0L);
/*     */     } finally {
/* 127 */       if (0 != Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) {
/* 128 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getJoinStatus() {
/* 138 */     return getJoinStatus(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getJoinStatus(String paramString) {
/* 147 */     PointerByReference pointerByReference = new PointerByReference();
/* 148 */     IntByReference intByReference = new IntByReference();
/*     */     
/*     */     try {
/* 151 */       int i = Netapi32.INSTANCE.NetGetJoinInformation(paramString, pointerByReference, intByReference);
/* 152 */       if (0 != i) {
/* 153 */         throw new Win32Exception(i);
/*     */       }
/* 155 */       return intByReference.getValue();
/*     */     } finally {
/* 157 */       if (pointerByReference.getPointer() != null) {
/* 158 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 159 */         if (0 != i) {
/* 160 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDomainName(String paramString) {
/* 172 */     PointerByReference pointerByReference = new PointerByReference();
/* 173 */     IntByReference intByReference = new IntByReference();
/*     */     
/*     */     try {
/* 176 */       int i = Netapi32.INSTANCE.NetGetJoinInformation(paramString, pointerByReference, intByReference);
/* 177 */       if (0 != i) {
/* 178 */         throw new Win32Exception(i);
/*     */       }
/*     */       
/* 181 */       return pointerByReference.getValue().getWideString(0L);
/*     */     } finally {
/* 183 */       if (pointerByReference.getPointer() != null) {
/* 184 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 185 */         if (0 != i) {
/* 186 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LocalGroup[] getLocalGroups() {
/* 197 */     return getLocalGroups(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LocalGroup[] getLocalGroups(String paramString) {
/* 206 */     PointerByReference pointerByReference = new PointerByReference();
/* 207 */     IntByReference intByReference1 = new IntByReference();
/* 208 */     IntByReference intByReference2 = new IntByReference();
/*     */     try {
/* 210 */       int i = Netapi32.INSTANCE.NetLocalGroupEnum(paramString, 1, pointerByReference, -1, intByReference1, intByReference2, null);
/* 211 */       if (0 != i || pointerByReference.getValue() == Pointer.NULL) {
/* 212 */         throw new Win32Exception(i);
/*     */       }
/*     */       
/* 215 */       ArrayList<LocalGroup> arrayList = new ArrayList();
/*     */       
/* 217 */       if (intByReference1.getValue() > 0) {
/* 218 */         LMAccess.LOCALGROUP_INFO_1 lOCALGROUP_INFO_1 = new LMAccess.LOCALGROUP_INFO_1(pointerByReference.getValue());
/* 219 */         LMAccess.LOCALGROUP_INFO_1[] arrayOfLOCALGROUP_INFO_1 = (LMAccess.LOCALGROUP_INFO_1[])lOCALGROUP_INFO_1.toArray(intByReference1.getValue());
/* 220 */         for (LMAccess.LOCALGROUP_INFO_1 lOCALGROUP_INFO_11 : arrayOfLOCALGROUP_INFO_1) {
/* 221 */           LocalGroup localGroup = new LocalGroup();
/* 222 */           localGroup.name = lOCALGROUP_INFO_11.lgrui1_name;
/* 223 */           localGroup.comment = lOCALGROUP_INFO_11.lgrui1_comment;
/* 224 */           arrayList.add(localGroup);
/*     */         } 
/*     */       } 
/*     */       
/* 228 */       return arrayList.<LocalGroup>toArray(new LocalGroup[0]);
/*     */     } finally {
/* 230 */       if (pointerByReference.getValue() != Pointer.NULL) {
/* 231 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 232 */         if (0 != i) {
/* 233 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getGlobalGroups() {
/* 244 */     return getGlobalGroups(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getGlobalGroups(String paramString) {
/* 253 */     PointerByReference pointerByReference = new PointerByReference();
/* 254 */     IntByReference intByReference1 = new IntByReference();
/* 255 */     IntByReference intByReference2 = new IntByReference();
/*     */     try {
/* 257 */       int i = Netapi32.INSTANCE.NetGroupEnum(paramString, 1, pointerByReference, -1, intByReference1, intByReference2, null);
/*     */ 
/*     */       
/* 260 */       if (0 != i || pointerByReference.getValue() == Pointer.NULL) {
/* 261 */         throw new Win32Exception(i);
/*     */       }
/*     */       
/* 264 */       ArrayList<LocalGroup> arrayList = new ArrayList();
/*     */       
/* 266 */       if (intByReference1.getValue() > 0) {
/* 267 */         LMAccess.GROUP_INFO_1 gROUP_INFO_1 = new LMAccess.GROUP_INFO_1(pointerByReference.getValue());
/* 268 */         LMAccess.GROUP_INFO_1[] arrayOfGROUP_INFO_1 = (LMAccess.GROUP_INFO_1[])gROUP_INFO_1.toArray(intByReference1.getValue());
/* 269 */         for (LMAccess.GROUP_INFO_1 gROUP_INFO_11 : arrayOfGROUP_INFO_1) {
/* 270 */           LocalGroup localGroup = new LocalGroup();
/* 271 */           localGroup.name = gROUP_INFO_11.grpi1_name;
/* 272 */           localGroup.comment = gROUP_INFO_11.grpi1_comment;
/* 273 */           arrayList.add(localGroup);
/*     */         } 
/*     */       } 
/*     */       
/* 277 */       return arrayList.<Group>toArray((Group[])new LocalGroup[0]);
/*     */     } finally {
/* 279 */       if (pointerByReference.getValue() != Pointer.NULL) {
/* 280 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 281 */         if (0 != i) {
/* 282 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static User[] getUsers() {
/* 293 */     return getUsers(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static User[] getUsers(String paramString) {
/* 302 */     PointerByReference pointerByReference = new PointerByReference();
/* 303 */     IntByReference intByReference1 = new IntByReference();
/* 304 */     IntByReference intByReference2 = new IntByReference();
/*     */     try {
/* 306 */       int i = Netapi32.INSTANCE.NetUserEnum(paramString, 1, 0, pointerByReference, -1, intByReference1, intByReference2, null);
/*     */ 
/*     */ 
/*     */       
/* 310 */       if (0 != i || pointerByReference.getValue() == Pointer.NULL) {
/* 311 */         throw new Win32Exception(i);
/*     */       }
/*     */       
/* 314 */       ArrayList<User> arrayList = new ArrayList();
/*     */       
/* 316 */       if (intByReference1.getValue() > 0) {
/* 317 */         LMAccess.USER_INFO_1 uSER_INFO_1 = new LMAccess.USER_INFO_1(pointerByReference.getValue());
/* 318 */         LMAccess.USER_INFO_1[] arrayOfUSER_INFO_1 = (LMAccess.USER_INFO_1[])uSER_INFO_1.toArray(intByReference1.getValue());
/* 319 */         for (LMAccess.USER_INFO_1 uSER_INFO_11 : arrayOfUSER_INFO_1) {
/* 320 */           User user = new User();
/* 321 */           if (uSER_INFO_11.usri1_name != null) {
/* 322 */             user.name = uSER_INFO_11.usri1_name;
/*     */           }
/* 324 */           arrayList.add(user);
/*     */         } 
/*     */       } 
/*     */       
/* 328 */       return arrayList.<User>toArray(new User[0]);
/*     */     } finally {
/* 330 */       if (pointerByReference.getValue() != Pointer.NULL) {
/* 331 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 332 */         if (0 != i) {
/* 333 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getCurrentUserLocalGroups() {
/* 344 */     return getUserLocalGroups(Secur32Util.getUserNameEx(2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getUserLocalGroups(String paramString) {
/* 353 */     return getUserLocalGroups(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getUserLocalGroups(String paramString1, String paramString2) {
/* 363 */     PointerByReference pointerByReference = new PointerByReference();
/* 364 */     IntByReference intByReference1 = new IntByReference();
/* 365 */     IntByReference intByReference2 = new IntByReference();
/*     */     try {
/* 367 */       int i = Netapi32.INSTANCE.NetUserGetLocalGroups(paramString2, paramString1, 0, 0, pointerByReference, -1, intByReference1, intByReference2);
/*     */ 
/*     */       
/* 370 */       if (i != 0) {
/* 371 */         throw new Win32Exception(i);
/*     */       }
/* 373 */       ArrayList<LocalGroup> arrayList = new ArrayList();
/* 374 */       if (intByReference1.getValue() > 0) {
/* 375 */         LMAccess.LOCALGROUP_USERS_INFO_0 lOCALGROUP_USERS_INFO_0 = new LMAccess.LOCALGROUP_USERS_INFO_0(pointerByReference.getValue());
/* 376 */         LMAccess.LOCALGROUP_USERS_INFO_0[] arrayOfLOCALGROUP_USERS_INFO_0 = (LMAccess.LOCALGROUP_USERS_INFO_0[])lOCALGROUP_USERS_INFO_0.toArray(intByReference1.getValue());
/* 377 */         for (LMAccess.LOCALGROUP_USERS_INFO_0 lOCALGROUP_USERS_INFO_01 : arrayOfLOCALGROUP_USERS_INFO_0) {
/* 378 */           LocalGroup localGroup = new LocalGroup();
/* 379 */           if (lOCALGROUP_USERS_INFO_01.lgrui0_name != null) {
/* 380 */             localGroup.name = lOCALGROUP_USERS_INFO_01.lgrui0_name;
/*     */           }
/* 382 */           arrayList.add(localGroup);
/*     */         } 
/*     */       } 
/* 385 */       return arrayList.<Group>toArray(new Group[0]);
/*     */     } finally {
/* 387 */       if (pointerByReference.getValue() != Pointer.NULL) {
/* 388 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 389 */         if (0 != i) {
/* 390 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getUserGroups(String paramString) {
/* 402 */     return getUserGroups(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Group[] getUserGroups(String paramString1, String paramString2) {
/* 412 */     PointerByReference pointerByReference = new PointerByReference();
/* 413 */     IntByReference intByReference1 = new IntByReference();
/* 414 */     IntByReference intByReference2 = new IntByReference();
/*     */     try {
/* 416 */       int i = Netapi32.INSTANCE.NetUserGetGroups(paramString2, paramString1, 0, pointerByReference, -1, intByReference1, intByReference2);
/*     */ 
/*     */       
/* 419 */       if (i != 0) {
/* 420 */         throw new Win32Exception(i);
/*     */       }
/*     */       
/* 423 */       ArrayList<Group> arrayList = new ArrayList();
/*     */       
/* 425 */       if (intByReference1.getValue() > 0) {
/* 426 */         LMAccess.GROUP_USERS_INFO_0 gROUP_USERS_INFO_0 = new LMAccess.GROUP_USERS_INFO_0(pointerByReference.getValue());
/* 427 */         LMAccess.GROUP_USERS_INFO_0[] arrayOfGROUP_USERS_INFO_0 = (LMAccess.GROUP_USERS_INFO_0[])gROUP_USERS_INFO_0.toArray(intByReference1.getValue());
/* 428 */         for (LMAccess.GROUP_USERS_INFO_0 gROUP_USERS_INFO_01 : arrayOfGROUP_USERS_INFO_0) {
/* 429 */           Group group = new Group();
/* 430 */           if (gROUP_USERS_INFO_01.grui0_name != null) {
/* 431 */             group.name = gROUP_USERS_INFO_01.grui0_name;
/*     */           }
/* 433 */           arrayList.add(group);
/*     */         } 
/*     */       } 
/*     */       
/* 437 */       return arrayList.<Group>toArray(new Group[0]);
/*     */     } finally {
/* 439 */       if (pointerByReference.getValue() != Pointer.NULL) {
/* 440 */         int i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 441 */         if (0 != i) {
/* 442 */           throw new Win32Exception(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DomainController
/*     */   {
/*     */     public String name;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String address;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int addressType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Guid.GUID domainGuid;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String domainName;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String dnsForestName;
/*     */ 
/*     */ 
/*     */     
/*     */     public int flags;
/*     */ 
/*     */ 
/*     */     
/*     */     public String clientSiteName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DomainController getDC() {
/* 494 */     DsGetDC.PDOMAIN_CONTROLLER_INFO pDOMAIN_CONTROLLER_INFO = new DsGetDC.PDOMAIN_CONTROLLER_INFO();
/* 495 */     int i = Netapi32.INSTANCE.DsGetDcName(null, null, null, null, 0, pDOMAIN_CONTROLLER_INFO);
/* 496 */     if (0 != i) {
/* 497 */       throw new Win32Exception(i);
/*     */     }
/* 499 */     DomainController domainController = new DomainController();
/* 500 */     domainController.address = pDOMAIN_CONTROLLER_INFO.dci.DomainControllerAddress;
/* 501 */     domainController.addressType = pDOMAIN_CONTROLLER_INFO.dci.DomainControllerAddressType;
/* 502 */     domainController.clientSiteName = pDOMAIN_CONTROLLER_INFO.dci.ClientSiteName;
/* 503 */     domainController.dnsForestName = pDOMAIN_CONTROLLER_INFO.dci.DnsForestName;
/* 504 */     domainController.domainGuid = pDOMAIN_CONTROLLER_INFO.dci.DomainGuid;
/* 505 */     domainController.domainName = pDOMAIN_CONTROLLER_INFO.dci.DomainName;
/* 506 */     domainController.flags = pDOMAIN_CONTROLLER_INFO.dci.Flags;
/* 507 */     domainController.name = pDOMAIN_CONTROLLER_INFO.dci.DomainControllerName;
/* 508 */     i = Netapi32.INSTANCE.NetApiBufferFree(pDOMAIN_CONTROLLER_INFO.dci.getPointer());
/* 509 */     if (0 != i) {
/* 510 */       throw new Win32Exception(i);
/*     */     }
/* 512 */     return domainController;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DomainTrust
/*     */   {
/*     */     public String NetbiosDomainName;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String DnsDomainName;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.PSID DomainSid;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String DomainSidString;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Guid.GUID DomainGuid;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String DomainGuidString;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int flags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInForest() {
/* 559 */       return ((this.flags & 0x1) != 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isOutbound() {
/* 570 */       return ((this.flags & 0x2) != 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isRoot() {
/* 581 */       return ((this.flags & 0x4) != 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isPrimary() {
/* 591 */       return ((this.flags & 0x8) != 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNativeMode() {
/* 600 */       return ((this.flags & 0x10) != 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInbound() {
/* 611 */       return ((this.flags & 0x20) != 0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DomainTrust[] getDomainTrusts() {
/* 621 */     return getDomainTrusts(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DomainTrust[] getDomainTrusts(String paramString) {
/* 632 */     IntByReference intByReference = new IntByReference();
/* 633 */     PointerByReference pointerByReference = new PointerByReference();
/* 634 */     int i = Netapi32.INSTANCE.DsEnumerateDomainTrusts(paramString, 63, pointerByReference, intByReference);
/*     */     
/* 636 */     if (0 != i) {
/* 637 */       throw new Win32Exception(i);
/*     */     }
/*     */     try {
/* 640 */       ArrayList<DomainTrust> arrayList = new ArrayList(intByReference.getValue());
/*     */       
/* 642 */       if (intByReference.getValue() > 0) {
/* 643 */         DsGetDC.DS_DOMAIN_TRUSTS dS_DOMAIN_TRUSTS = new DsGetDC.DS_DOMAIN_TRUSTS(pointerByReference.getValue());
/* 644 */         DsGetDC.DS_DOMAIN_TRUSTS[] arrayOfDS_DOMAIN_TRUSTS = (DsGetDC.DS_DOMAIN_TRUSTS[])dS_DOMAIN_TRUSTS.toArray((Structure[])new DsGetDC.DS_DOMAIN_TRUSTS[intByReference.getValue()]);
/* 645 */         for (DsGetDC.DS_DOMAIN_TRUSTS dS_DOMAIN_TRUSTS1 : arrayOfDS_DOMAIN_TRUSTS) {
/* 646 */           DomainTrust domainTrust = new DomainTrust();
/* 647 */           if (dS_DOMAIN_TRUSTS1.DnsDomainName != null) {
/* 648 */             domainTrust.DnsDomainName = dS_DOMAIN_TRUSTS1.DnsDomainName;
/*     */           }
/* 650 */           if (dS_DOMAIN_TRUSTS1.NetbiosDomainName != null) {
/* 651 */             domainTrust.NetbiosDomainName = dS_DOMAIN_TRUSTS1.NetbiosDomainName;
/*     */           }
/* 653 */           domainTrust.DomainSid = dS_DOMAIN_TRUSTS1.DomainSid;
/* 654 */           if (dS_DOMAIN_TRUSTS1.DomainSid != null) {
/* 655 */             domainTrust.DomainSidString = Advapi32Util.convertSidToStringSid(dS_DOMAIN_TRUSTS1.DomainSid);
/*     */           }
/* 657 */           domainTrust.DomainGuid = dS_DOMAIN_TRUSTS1.DomainGuid;
/* 658 */           if (dS_DOMAIN_TRUSTS1.DomainGuid != null) {
/* 659 */             domainTrust.DomainGuidString = Ole32Util.getStringFromGUID(dS_DOMAIN_TRUSTS1.DomainGuid);
/*     */           }
/* 661 */           domainTrust.flags = dS_DOMAIN_TRUSTS1.Flags;
/* 662 */           arrayList.add(domainTrust);
/*     */         } 
/*     */       } 
/*     */       
/* 666 */       return arrayList.<DomainTrust>toArray(new DomainTrust[0]);
/*     */     } finally {
/* 668 */       i = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
/* 669 */       if (0 != i) {
/* 670 */         throw new Win32Exception(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static UserInfo getUserInfo(String paramString) {
/* 676 */     return getUserInfo(paramString, getDCName());
/*     */   }
/*     */   
/*     */   public static UserInfo getUserInfo(String paramString1, String paramString2) {
/* 680 */     PointerByReference pointerByReference = new PointerByReference();
/*     */     try {
/* 682 */       int i = Netapi32.INSTANCE.NetUserGetInfo(paramString2, paramString1, 23, pointerByReference);
/* 683 */       if (i == 0) {
/* 684 */         LMAccess.USER_INFO_23 uSER_INFO_23 = new LMAccess.USER_INFO_23(pointerByReference.getValue());
/* 685 */         UserInfo userInfo = new UserInfo();
/* 686 */         userInfo.comment = uSER_INFO_23.usri23_comment;
/* 687 */         userInfo.flags = uSER_INFO_23.usri23_flags;
/* 688 */         userInfo.fullName = uSER_INFO_23.usri23_full_name;
/* 689 */         userInfo.name = uSER_INFO_23.usri23_name;
/* 690 */         if (uSER_INFO_23.usri23_user_sid != null) {
/* 691 */           userInfo.sidString = Advapi32Util.convertSidToStringSid(uSER_INFO_23.usri23_user_sid);
/*     */         }
/* 693 */         userInfo.sid = uSER_INFO_23.usri23_user_sid;
/* 694 */         return userInfo;
/*     */       } 
/* 696 */       throw new Win32Exception(i);
/*     */     } finally {
/*     */       
/* 699 */       if (pointerByReference.getValue() != Pointer.NULL)
/* 700 */         Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Netapi32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */