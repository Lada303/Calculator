package com.company;

public class ConvertingRomNum {

  static String ConvArabRom (int Arab) {
        if (Arab==100) return ("C");
        int Arab1=Arab%10, Arab10=Arab/10, ArabBuf;
        String Rom1="", Rom10="";
        StringBuilder RomBuf;

        RomNumber[] AllRom = RomNumber.values();
        for (int j=0; j < AllRom.length-1; j++) {
             if (Arab == AllRom[j].getEqv()) return (AllRom[j].name());
             else {
                   if (Arab1 != 0) {
                       if (Arab1 == AllRom[j].getEqv()) Rom1 = AllRom[j].name();
                       if (Arab1 > AllRom[j].getEqv() && Arab1 < AllRom[j + 1].getEqv()) {
                           if (AllRom[j+1].getEqv()-Arab1 !=1) {
                               RomBuf = new StringBuilder(AllRom[j].name());
                               ArabBuf = AllRom[j].getEqv();
                               while (ArabBuf < Arab1) {
                                   ArabBuf++;
                                   RomBuf.append('I');
                               }
                           }
                           else {
                               RomBuf = new StringBuilder("I");
                               RomBuf.append(AllRom[j+1].name());
                           }
                        Rom1 = RomBuf.toString();
                        if (Arab10 == 0) return (Rom1);
                       }
                   }
                    if (Arab10 !=0 ){
                        if (Arab10*10 == AllRom[j].getEqv()) Rom10 = AllRom[j].name();
                        if (Arab10*10>AllRom[j].getEqv() & Arab10*10 <AllRom[j+1].getEqv()){
                            if (AllRom[j+1].getEqv()-Arab10*10 !=10) {
                                RomBuf = new StringBuilder(AllRom[j].name());
                                ArabBuf = AllRom[j].getEqv();
                                while (ArabBuf < Arab10*10) {
                                    ArabBuf=ArabBuf+10;
                                    RomBuf.append('X');
                                }
                            }
                            else {
                                RomBuf = new StringBuilder("X");
                                RomBuf.append(AllRom[j+1].name());
                            }
                             Rom10= RomBuf.toString();
                        }
                    }
             }
        }
        return (Rom10+Rom1);
  }

   static int RecognizeRom (String RN){
        int NumReturn=0, count=0;
        int countV=0, countI=0;
        RomNumber[] AllRom = RomNumber.values();
        int [] anRom = new int[RN.length()];
        for (int i=0; i<RN.length(); i++){
           for (RomNumber AllRomJ : AllRom) {
                if (AllRomJ.name().equalsIgnoreCase(RN.substring(i,i+1))) {
                    anRom[i] = AllRomJ.getEqv();
                    count++;
                    if (anRom[i] == 1) countI++;  if (countI > 3) return (0);
                    if (anRom[i] == 5) countV++;  if (countV > 1) return (0);
                    if (i==0)
                        if (anRom[i] !=0) NumReturn=anRom[i];
                        else return 0;
                    else
                       if (anRom[i-1] >= anRom[i])NumReturn=NumReturn+anRom[i];
                       else {
                           if (NumReturn>1) return 0;
                           NumReturn = anRom[i]-NumReturn;
                           if (count == RN.length()) return NumReturn;
                           else return 0;
                       }
                }
           }
            if (count ==0 || count != i+1) return (0);
        }
        return NumReturn;
  }
}
