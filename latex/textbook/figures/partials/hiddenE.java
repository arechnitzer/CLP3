                  /*  File:  hiddenE.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hiddenE extends Template {

     static {templateClass = new hiddenE() ; }

     public void setup() {
          filePrefix = "hiddenE" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 20*0.15 ;   
          ysize = 14*0.15 ;   
          xmin = -10  ;
          xmax = 10 ;
          ymin = -7 ;
          ymax = 7 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double r = 0.2 ;
          double OX = 5 ; double OY = 3 ;
          double IX = 2 ; double IY = 1 ;
          double SX = 1.0 ; double SY = 0.5 ;
          double x = 3 ; double y = OY*Math.sqrt(1-x*x/(OX*OX)) ;
          double ex = 6*1.2 ; double ey = 4.5*1.2 ;
          double vx = 0.5*(ex-x) ; double vy = 0.5*(ey-y) ;
          double nx = x/(OX*OX) ; double ny = y/(OY*OY) ;

       
          double th = 20 ; double thRad = th*Math.PI/180 ;
          double phiRad = Math.atan(vy/vx) ; double phi = phiRad*180/Math.PI ;
          double vxu = vx*Math.cos(thRad) -vy*Math.sin(thRad) ;
          double vyu = vx*Math.sin(thRad) +vy*Math.cos(thRad) ;
          double vxl = vx*Math.cos(thRad) +vy*Math.sin(thRad) ;
          double vyl = -vx*Math.sin(thRad) +vy*Math.cos(thRad) ;
          double re = 1.0/(Math.sqrt(vx*vx+vy*vy)) ;
          double re2 = 0.75/(Math.sqrt(vx*vx+vy*vy)) ;


          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.6) ;
          fDisk(0,0, OX,OY, CLOSED+FILLED) ;
          fTeXlabel(0.6*OX, -0.8*OY-0.2, "tl", "$\\scriptstyle G(x,y,z)=0$") ;

          fEnv("lineWidth", 0.5) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fLine(ex-1.3*re2*vx,ey-1.3*re2*vy, x,y) ;
          fArrow(x,y, x-vx,y-vy) ;
          fTeXlabel(x-vx,y-vy+0.2, "cr", "$\\scriptstyle\\vv$") ;
          fLine(x-10*ny, y+10*nx, x+10*ny, y-10*nx) ;
          fArrow(x,y, x+10*nx,y+10*ny) ;
          fTeXlabel(x+10*nx,y+10*ny+0.2, "cb", "$\\scriptstyle\\vn$") ;

//          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
//          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fEnv("psFillGray", 0.85) ;
          fDisk(x,y, r,r, CLOSED+FILLED) ;
          fTeXlabel(x+0.6,y+0.1, "cl", "$\\scriptstyle(x,y,z)$") ;

          fLine(ex,ey, ex-re*vxu, ey-re*vyu) ;
          fLine(ex,ey, ex-re*vxl, ey-re*vyl) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(ex,ey, 0.75, 0.75, 180+phi-th, 180+phi+th, FILLED+WEDGE) ;
          fEllipticalArc(ex,ey, 0.75, 0.75, 180+phi-th, 180+phi+th, OPEN) ;
          fTeXlabel(ex+0.2,ey, "cl", "$\\scriptstyle(x_e,y_e,z_e)$") ;

          double a = vx*vx/(OX*OX) + vy*vy/(OY*OY) ;
          double b = -2*ex*vx/(OX*OX) -2*ey*vy/(OY*OY) ;
          double c = ex*ex/(OX*OX) + ey*ey/(OY*OY) -1;
          double t1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a) ; 
          double x1 = ex-t1*vx ; double y1 = ey-t1*vy ;
          fEnv("psFillGray", 0.3) ;
          fDisk(x1,y1, r,r, CLOSED+FILLED) ;
          fTeXlabel(x1+0.6,y1+0.1, "cl", "$\\scriptstyle(x',y',z')$") ;
          fLine(x-vx, y-vy, x1, y1 ) ;
          fArrow(x1,y1, x1-vx,y1-vy) ;
          fTeXlabel(x1-vx,y1-vy+0.2, "cr", "$\\scriptstyle\\vv$") ;
          double nx1 = x1/(OX*OX) ; double ny1 = y1/(OY*OY) ;
          fLine(x1-10*ny1, y1+10*nx1, x1+10*ny1, y1-10*nx1) ;
          fArrow(x1,y1, x1+10*nx1,y1+10*ny1) ;
          fTeXlabel(x1+10*nx1+0.5,y1+10*ny1+0.2, "cl", "$\\scriptstyle\\vn'$") ;


     }
}
