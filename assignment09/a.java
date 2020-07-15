import java.io.*;
import java.util.*;

public class Front
{ 
    switch(k)
    {
        case 1:
        case 2:
            j=2 * k -1; break;
        case 3:
        case 4:
            j=3 * k +1; break;
        case 5:
            j=4 * k -1; break;
        case 6:
        case 7: 
        case 8:
            j=k-2; break;
        default:
            system.out.println("Error!!!");
            k=0; break;

    }

   
}


j=-3;
for (int i=0;i<3 ; i++)
{
    int jValue=j +2;
    if(jValue==3 || jValue==2)
        j--;
    else if (jValue==0)
        j+=2;
    else 
        j =0 ;
    
    if(j <= 0)
        j= 3 - i ;

}



for(i=1;i<=n;i++)
{   int check=1;
    for(j=0;j<=n;j++)
        if(x[i][j] ==0)
        {
             check=0;
             break;
        }
           
    if(check==1)
    {
        system.out.println("First all-zero row is " + i);
        break;
    }
}