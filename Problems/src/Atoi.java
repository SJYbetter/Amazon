class Atoi {
    //1. remove all front white space
    //2. decide positive or negative
    //3. start with number rather than number
    //4. >than 2^32-1 overflow

    public int myAtoi(String str) {

        double result = 0;
        int flag = 1;
        int count = 0;
        char[] charArr = str.toCharArray();
        
        for(char c : charArr){
            count ++;
            //if c is numeric
            if( c >='0' && c <='9' ){
                result *= 10;
                result += ( c - '0');
            }else if( c == '-' && count == 1){
                flag = -1;
            }else if( c == '+' && count == 1){
                flag =  1;
            }else if( c == ' ' && count == 1){
                count --;
            }else{
                //start with not number, not sign
                break;
            }

        }
        //overflow
        if( result > Integer.MAX_VALUE ){
            if(flag == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }

        return (int) (result * flag);

    }
}
