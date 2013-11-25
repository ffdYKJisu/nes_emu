package ffdYKJisu.nes_emu.system;

import java.util.Map;

import com.google.common.collect.Maps;

import ffdYKJisu.nes_emu.domain.AddressingMode;

/**
 * Stores static information about opcodes
 * @author fcf
 *
 */
public enum Opcode { 
    BRK("00", "BRK", 7, 1, AddressingMode.IMPLICIT),
    ORAix("01", "ORA", 6, 2, AddressingMode.INDIRECT_X),
    ORAz("05", "ORA", 3, 2, AddressingMode.ZERO_PAGE),
    ASLz("06", "ASL", 5, 2, AddressingMode.ZERO_PAGE),
    PHP("08", "PHP", 3, 1, AddressingMode.IMPLICIT),
    ORA("09", "ORA", 2, 2, AddressingMode.IMMEDIATE),
    ASLac("06", "ASL", 2, 1, AddressingMode.ACCUMULATOR),
    ORAa("0D", "ORA", 4, 3, AddressingMode.ABSOLUTE),
    ASLa("OE", "ASL", 6, 3, AddressingMode.ABSOLUTE)
    ;

/*
<?xml version="1.0" encoding="UTF-8"?>
<Operations>
  <Opcode id="00" printName="BRK" cycles="7" length="1" addressingMode="Implied" />
  <Opcode id="01" printName="ORA" cycles="6" length="2" addressingMode="(Indirect,X)" />
  <Opcode id="05" printName="ORA" cycles="3" length="2" addressingMode="Zero Page" />
  <Opcode id="06" printName="ASL" cycles="5" length="2" addressingMode="Zero Page" />
  <Opcode id="08" printName="PHP" cycles="3" length="1" addressingMode="Implied" />
  <Opcode id="09" printName="ORA" cycles="2" length="2" addressingMode="Immediate" />
  <Opcode id="0A" printName="ASL" cycles="2" length="1" addressingMode="Accumulator" />
  <Opcode id="0D" printName="ORA" cycles="4" length="3" addressingMode="Absolute" />
  <Opcode id="0E" printName="ASL" cycles="6" length="3" addressingMode="Absolute" />
  */
    private final String opcodeBytes;
    private final String codeName;
    private final int cycles;
    private final int length;
    private final boolean extraCycleOnBranch;
    private final boolean extraCycleOnPageJump;
    private final AddressingMode addressingMode;
    private final Map<String, Opcode> opcodeMap = Maps.newHashMap();
    
    Opcode(String opcodeBytes, String codeName, int cycles, int length, AddressingMode addressingMode) {
        this(opcodeBytes, codeName, cycles, length, false, false, addressingMode);       
    }
    
    Opcode(String opcodeBytes, String codeName, int cycles, int length, boolean extraCycleOnBranch, 
            boolean extraCycleOnPageJump, AddressingMode addressingMode) {
        this.opcodeBytes = opcodeBytes;
        this.codeName = codeName;
        this.cycles = cycles;
        this.length = length;
        this.extraCycleOnBranch = extraCycleOnBranch;
        this.extraCycleOnPageJump = extraCycleOnPageJump;
        this.addressingMode = addressingMode;        
        opcodeMap.put(opcodeBytes, this);       
    }
    
    public Opcode getOpcodeByBytes(String opcodeBytes) {
        return opcodeMap.get(opcodeBytes);
    }
   /*
      <Opcode id="10" printName="BPL" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="11" printName="ORA" cycles="5" length="2" addressingMode="(Indirect),Y" />
      <Opcode id="15" printName="ORA" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="16" printName="ASL" cycles="6" length="2" addressingMode="Zero Page,X" />
      <Opcode id="18" printName="CLC" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="19" printName="ORA" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="1D" printName="ORA" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="1E" printName="ASL" cycles="7" length="3" addressingMode="Absolute, X" />
      <Opcode id="20" printName="JSR" cycles="6" length="3" addressingMode="Absolute" />
      <Opcode id="21" printName="AND" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="24" printName="BIT" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="25" printName="AND" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="26" printName="ROL" cycles="5" length="2" addressingMode="Zero Page" />
      <Opcode id="28" printName="PLP" cycles="4" length="1" addressingMode="Implied" />
      <Opcode id="29" printName="AND" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="2A" printName="ROL" cycles="2" length="1" addressingMode="Accumulator" />
      <Opcode id="2C" printName="BIT" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="2D" printName="AND" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="2E" printName="ROL" cycles="6" length="3" addressingMode="Absolute" />
      <Opcode id="30" printName="BMI" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="31" printName="AND" cycles="5" length="2" addressingMode="(Indirect,Y)" />
      <Opcode id="35" printName="AND" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="36" printName="ROL" cycles="6" length="2" addressingMode="Zero Page,X" />
      <Opcode id="38" printName="SEC" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="39" printName="AND" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="3D" printName="AND" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="3E" printName="ROL" cycles="7" length="3" addressingMode="Absolute,X" />
      <Opcode id="40" printName="EOR" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="41" printName="EOR" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="45" printName="EOR" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="46" printName="LSR" cycles="5" length="2" addressingMode="Zero Page" />
      <Opcode id="48" printName="PHA" cycles="3" length="1" addressingMode="Implied" />
      <Opcode id="49" printName="EOR" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="4A" printName="LSR" cycles="2" length="1" addressingMode="Accumulator" />
      <Opcode id="4C" printName="JMP" cycles="3" length="3" addressingMode="Absolute" />
      <Opcode id="4D" printName="RTI" cycles="6" length="1" addressingMode="Implied" />
      <Opcode id="4E" printName="LSR" cycles="6" length="3" addressingMode="Absolute" />
      <Opcode id="50" printName="BVC" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="51" printName="EOR" cycles="5" length="2" addressingMode="(Indirect),Y" onPageJumpCycle="1" />
      <Opcode id="55" printName="EOR" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="56" printName="LSR" cycles="6" length="2" addressingMode="Zero Page,X" />
      <Opcode id="58" printName="CLI" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="59" printName="EOR" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="5D" printName="EOR" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="5E" printName="LSR" cycles="7" length="3" addressingMode="Absolute,X" />
      <Opcode id="60" printName="RTS" cycles="6" length="1" addressingMode="Implied" />
      <Opcode id="61" printName="ADC" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="65" printName="ADC" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="66" printName="ROR" cycles="5" length="2" addressingMode="Zero Page" />
      <Opcode id="68" printName="PLA" cycles="4" length="1" addressingMode="Implied" />
      <Opcode id="69" printName="ADC" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="6A" printName="ROR" cycles="2" length="1" addressingMode="Accumulator" />
      <Opcode id="6C" printName="JMP" cycles="5" length="3" addressingMode="Indirect" />
      <Opcode id="6D" printName="ADC" length="3" cycles="4" addressingMode="Absolute" />
      <Opcode id="6E" printName="ROR" cycles="6" length="3" addressingMode="Absolute" />
      <Opcode id="70" printName="BVS" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="71" printName="ADC" cycles="5" length="2" addressingMode="(Indirect),Y" onPageJumpCycle="1" />
      <Opcode id="75" printName="ADC" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="76" printName="ROR" cycles="6" length="2" addressingMode="Zero Page,X" />
      <Opcode id="78" printName="SEI" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="79" printName="ADC" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="7D" printName="ADC" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="7E" printName="ROR" cycles="7" length="3" addressingMode="Absolute,X" />
      <Opcode id="81" printName="STA" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="84" printName="STY" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="85" printName="STA" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="86" printName="STX" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="88" printName="DEY" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="8A" printName="TXA" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="8C" printName="STY" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="8D" printName="STA" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="8E" printName="STX" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="90" printName="BCC" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="91" printName="STA" cycles="6" length="2" addressingMode="(Indirect),Y" />
      <Opcode id="94" printName="STY" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="95" printName="STA" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="96" printName="STX" cycles="4" length="2" addressingMode="Zero Page,Y" />
      <Opcode id="98" printName="TYA" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="99" printName="STA" cycles="5" length="3" addressingMode="Absolute,Y" />
      <Opcode id="9A" printName="TXS" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="9D" printName="STA" cycles="5" length="3" addressingMode="Absolute,X" />
      <Opcode id="A0" printName="LDY" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="A1" printName="LDA" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="A2" printName="LDX" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="A4" printName="LDY" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="A5" printName="LDA" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="A6" printName="LDX" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="A8" printName="TAY" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="A9" printName="LDA" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="AA" printName="TAX" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="AC" printName="LDY" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="AD" printName="LDA" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="AE" printName="LDX" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="B0" printName="BCS" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="B1" printName="LDA" cycles="5" length="2" addressingMode="(Indirect),Y" onPageJumpCycle="1" />
      <Opcode id="B4" printName="LDY" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="B5" printName="LDA" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="B6" printName="LDX" cycles="4" length="2" addressingMode="Zero Page,Y" />
      <Opcode id="B8" printName="CLV" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="B9" printName="LDA" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="BA" printName="TSX" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="BC" printName="LDY" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="BD" printName="LDA" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="BE" printName="LDX" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="C0" printName="CPY" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="C1" printName="CMP" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="C4" printName="CPY" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="C5" printName="CMP" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="C6" printName="DEC" cycles="5" length="2" addressingMode="Zero Page" />
      <Opcode id="C8" printName="INY" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="C9" printName="CMP" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="CA" printName="DEX" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="CC" printName="CPY" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="CD" printName="CMP" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="CE" printName="DEC" cycles="6" length="3" addressingMode="Absolute" />
      <Opcode id="D0" printName="BNE" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="D1" printName="CMP" cycles="5" length="2" addressingMode="(Indirect),Y" onPageJumpCycle="1" />
      <Opcode id="D5" printName="CMP" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="D6" printName="DEC" cycles="6" length="2" addressingMode="Zero Page,X" />
      <Opcode id="D8" printName="CLD" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="D9" printName="CMP" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="DD" printName="CMP" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="DE" printName="DEC" cycles="7" length="3" addressingMode="Absolute,X" />
      <Opcode id="E0" printName="CPX" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="E1" printName="SBC" cycles="6" length="2" addressingMode="(Indirect,X)" />
      <Opcode id="E4" printName="CPX" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="E5" printName="SBC" cycles="3" length="2" addressingMode="Zero Page" />
      <Opcode id="E6" printName="INC" cycles="5" length="2" addressingMode="Zero Page" />
      <Opcode id="E8" printName="INX" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="E9" printName="SBC" cycles="2" length="2" addressingMode="Immediate" />
      <Opcode id="EA" printName="NOP" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="EC" printName="CPX" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="ED" printName="SBC" cycles="4" length="3" addressingMode="Absolute" />
      <Opcode id="EE" printName="INC" cycles="6" length="3" addressingMode="Absolute" />
      <Opcode id="F0" printName="BEQ" cycles="2" length="2" addressingMode="Relative" onBranchCycle="1" onPageJumpCycle="1" />
      <Opcode id="F1" printName="SBC" cycles="5" length="2" addressingMode="(Indirect),Y" />
      <Opcode id="F5" printName="SBC" cycles="4" length="2" addressingMode="Zero Page,X" />
      <Opcode id="F6" printName="INC" cycles="6" length="2" addressingMode="Zero Page,X" />
      <Opcode id="F8" printName="SED" cycles="2" length="1" addressingMode="Implied" />
      <Opcode id="F9" printName="SBC" cycles="4" length="3" addressingMode="Absolute,Y" onPageJumpCycle="1" />
      <Opcode id="FD" printName="SBC" cycles="4" length="3" addressingMode="Absolute,X" onPageJumpCycle="1" />
      <Opcode id="FE" printName="INC" cycles="7" length="3" addressingMode="Absolute,X" />
    </Operations>*/
}