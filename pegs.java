/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingpegsiii;

/**
 *
 * @author hhira
 */

/**
 *
 * @author hhira
 */
public class pegs {

private int pegLRQty;
private int pegRLQty;
private int pegLRColor;
private int pegRLColor;
private int pegLRType;
private int pegRLType;




//constructor for case in which no definition is made.
public pegs()
{
    pegLRQty = 1;
    pegRLQty = 1;
    pegLRColor = 1;
    pegRLColor = 2;
    pegLRType = 1;
    pegRLType = 2;
    
}

public pegs(int pegLRQ, int pegRLQ, int pegLRC, int pegRLC, int pegRLT, int pegLRT)
{
    pegLRQty = pegLRQ;
    pegRLQty = pegRLQ;
    pegLRColor = pegLRC;
    pegRLColor = pegRLC;
    pegLRType = pegLRT;
    pegRLType = pegRLT;
}

public int getPegsLR()
{
    return pegLRQty;
}

public int getPegsRL()
{
    return pegRLQty;
}

}

