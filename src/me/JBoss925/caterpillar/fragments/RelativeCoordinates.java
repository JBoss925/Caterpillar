package me.JBoss925.caterpillar.fragments;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JBoss925 on 6/23/16.
 */
public class RelativeCoordinates {

    public int x;
    public int y;
    public int z;


    public RelativeCoordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static List<Location> getAbsoluteLocations(List<RelativeCoordinates> list, Location origin){
        List<Location> returnList = new ArrayList<Location>();
        for(RelativeCoordinates r : list){
            double tempBlockX = (double) origin.getBlockX() + r.getX();
            double tempBlockY = (double) origin.getBlockY() + r.getY();
            double tempBlockZ = (double) origin.getBlockZ() + r.getZ();
            Location temploc = new Location(origin.getWorld(), tempBlockX, tempBlockY, tempBlockZ);
            returnList.add(temploc);
        }
        return returnList;
    }

    public static List<RelativeCoordinates> getRelativeCoordinates(List<Location> locs, Location origin){
        List<RelativeCoordinates> relativeCoords = new ArrayList<RelativeCoordinates>();
        for(Location loc : locs){
            int tempRelX = loc.getBlockX() - origin.getBlockX();
            int tempRelY = loc.getBlockY() - origin.getBlockY();
            int tempRelZ = loc.getBlockZ() - origin.getBlockZ();
            RelativeCoordinates relComplete = new RelativeCoordinates(tempRelX, tempRelY, tempRelZ);
            relativeCoords.add(relComplete);
        }
        return relativeCoords;
    }

    public static List<Location> getAbsoluteLocationsWithinTwoLocations(Location loc1, Location loc2){
        double startx = (double) Math.min(loc1.getBlockX(), loc2.getBlockX());
        double endx = (double) Math.max(loc1.getBlockX(), loc2.getBlockX());
        double starty = (double) Math.min(loc1.getBlockY(), loc2.getBlockY());
        double endy = (double) Math.max(loc1.getBlockY(), loc2.getBlockY());
        double startz = (double) Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        double endz = (double) Math.max(loc1.getBlockZ(), loc2.getBlockZ());
        List<Location> locs = new ArrayList<Location>();
        for(double x = startx; x<= endx; x++){
            for(double y = starty; y<= endy; y++){
                for(double z = startz; z<= endz; z++){
                    locs.add(new Location(loc1.getWorld(), x, y, z));
                }
            }
        }
        return locs;
    }

    public static Location getOriginWithinTwoLocations(Location loc1, Location loc2){
        double middlex = (double) Math.min(loc1.getBlockX(), loc2.getBlockX()) + (Math.max(loc1.getBlockX(), loc2.getBlockX()) - Math.min(loc1.getBlockX(), loc2.getBlockX()));
        double middley = (double) Math.min(loc1.getBlockY(), loc2.getBlockY()) + (Math.max(loc1.getBlockY(), loc2.getBlockY()) - Math.min(loc1.getBlockY(), loc2.getBlockY()));
        double middlez = (double) Math.min(loc1.getBlockZ(), loc2.getBlockZ()) + (Math.max(loc1.getBlockZ(), loc2.getBlockZ()) - Math.min(loc1.getBlockZ(), loc2.getBlockZ()));
        return new Location(loc1.getWorld(), middlex, middley, middlez);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

}
