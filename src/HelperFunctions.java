import java.util.ArrayList;

public class HelperFunctions
{
    public static final int CLEAR_SEGMENT = 0b100000000;

    public static void ClearSingleSegment(int adres)
    {
        IO.writeShort(adres, CLEAR_SEGMENT);
    }

    public static void ClearAllSegmentDisplays()
    {
        IO.writeShort(0x34, CLEAR_SEGMENT);
        IO.writeShort(0x32, CLEAR_SEGMENT);
        IO.writeShort(0x30, CLEAR_SEGMENT);
        IO.writeShort(0x24, CLEAR_SEGMENT);
        IO.writeShort(0x22, CLEAR_SEGMENT);
        IO.writeShort(0x20, CLEAR_SEGMENT);
        IO.writeShort(0x18, CLEAR_SEGMENT);
        IO.writeShort(0x16, CLEAR_SEGMENT);
        IO.writeShort(0x14, CLEAR_SEGMENT);
        IO.writeShort(0x12, CLEAR_SEGMENT);
        IO.writeShort(0x10, CLEAR_SEGMENT);
    }

    public static void ClearMatrixDisplay()
    {
        ClearPixelDisplay();
        ClearTextDisplay();
    }

    public static void ClearPixelDisplay()
    {
        IO.writeShort(0x42, 3 << 12);  // Clear display
    }

    public static void ClearTextDisplay() {
        IO.writeShort(0x40, 0xFE);
        IO.writeShort(0x40, 0x01);
    }

    public static void ClearAll()
    {
        ClearAllSegmentDisplays();
        ClearMatrixDisplay();
    }

    public static ArrayList<Integer> ToDigitList(int number) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add( number % 10 );
            number = number / 10;
        }
        return digits;
    }

    public static void WriteValueOnSegments(int segmentDisplayGroup, double value, int numbersBehindComma) {
        int[] SegmentNumbersToBinary = new int[10];
        SegmentNumbersToBinary[0] = 319;
        SegmentNumbersToBinary[1] = 262;
        SegmentNumbersToBinary[2] = 347;
        SegmentNumbersToBinary[3] = 335;
        SegmentNumbersToBinary[4] = 358;
        SegmentNumbersToBinary[5] = 365;
        SegmentNumbersToBinary[6] = 381;
        SegmentNumbersToBinary[7] = 263;
        SegmentNumbersToBinary[8] = 383;
        SegmentNumbersToBinary[9] = 367;

        ArrayList<Integer> segmentAdresses = new ArrayList<>();
        switch (segmentDisplayGroup)
        {
            case 1:
                segmentAdresses.add(0x10);
                segmentAdresses.add(0x12);
                segmentAdresses.add(0x14);
                segmentAdresses.add(0x16);
                segmentAdresses.add(0x18);
                break;
            case 2:
                segmentAdresses.add(0x20);
                segmentAdresses.add(0x22);
                segmentAdresses.add(0x24);
                break;
            case 3:
                segmentAdresses.add(0x30);
                segmentAdresses.add(0x32);
                segmentAdresses.add(0x34);
                break;
        }

        boolean numberIsNegative = false;

        if (value == 0) {
            IO.writeShort(segmentAdresses.get(0), 0);
        } else {
            if(value < 0)
            {
                numberIsNegative = true;
                value = Math.abs(value);
            }

            double checkValue = value;
            value = Math.round(value* Math.pow(10, numbersBehindComma));
            ArrayList<Integer> myList = ToDigitList((int) value);
            if(checkValue < 1)
            {
                myList.add(0);
            }

            switch (numbersBehindComma) {
                case 1:
                    IO.writeShort(segmentAdresses.get(1), SegmentNumbersToBinary[myList.get(numbersBehindComma)] | 110000000);
                    break;
                case 2:
                    IO.writeShort(segmentAdresses.get(2), SegmentNumbersToBinary[myList.get(numbersBehindComma)] | 110000000);
                    break;
                case 3:
                    if (segmentAdresses.size() > 3) {
                        IO.writeShort(segmentAdresses.get(3), SegmentNumbersToBinary[myList.get(numbersBehindComma)] | 110000000);
                    }
                    break;
                case 4:
                    if (segmentAdresses.size() > 3) {
                        IO.writeShort(segmentAdresses.get(4), SegmentNumbersToBinary[myList.get(numbersBehindComma)] | 110000000);
                    }
                    break;
            }

            for (int j = 0; j < myList.size(); j++) {
                if((j != numbersBehindComma || j == 0)&&segmentAdresses.size()>j)
                {
                    IO.writeShort(segmentAdresses.get(j), myList.get(j));
                }
            }
            if(numberIsNegative)
            {
                if(myList.size() < segmentAdresses.size())
                {
                    int[] intArray = new int[]{6};
                    SetSegment(segmentAdresses.get(myList.size()),intArray);
                }
            }
        }
    }

    public static void WriteOnMatrixScreen(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++, j++) {
            if (chars[i] == '\n') {
                j = -1;
            }
            if (j % 21 == 0 && j > 0) {
                IO.writeShort(0x40, '\n');
            }
            IO.writeShort(0x40, chars[i]);
        }
    }

    public static void SetDisplayPixel(boolean on, int x, int y) {
        if (x >= 0 && x <= 127) {
            if (y >= 0 && y <= 31) {
                if(on)
                {
                    IO.writeShort(0x42, 1 << 12 | x << 5 | y);
                }
                else
                {
                    IO.writeShort(0x42, 0 << 12 | x << 5 | y);
                }
            }
        }
    }

    public static void SetSegment(int adres, int[] segments)
    {
        int[] singleSegments = new int[8];
        singleSegments[0] =  0b100000001;
        singleSegments[1] =  0b100000010;
        singleSegments[2]=   0b100000100;
        singleSegments[3] =  0b100001000;
        singleSegments[4] =  0b100010000;
        singleSegments[5] =  0b100100000;
        singleSegments[6] =  0b101000000;
        singleSegments[7] =  0b110000000;

        int writeValue = 0b100000000;
        for (int i = 0; i < segments.length; i++)
        {
            writeValue = writeValue | singleSegments[segments[i]];
        }
        IO.writeShort(adres, writeValue);
    }
}
