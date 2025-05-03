package tile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;
import main.emberlight.UtilityTool;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];
    boolean drawPath = true;
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[1000]; // Increase as needed for different tile variants
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        getTileImages();
        loadMap("/maps/world01.txt", 0);
        loadMap("/maps/interior01.txt", 1);
        loadMap("/maps/dungeon01.txt", 2);
        loadMap("/maps/bossdungeon01.txt", 3);
        loadMap("/maps/witchhut.txt", 4);
        loadMap("/maps/mayorhouse.txt", 5);
        loadMap("/maps/merchanthouse.txt", 6);
        loadMap("/maps/couplehouse.txt", 7);
        loadMap("/maps/punkhouse.txt", 8);
        loadMap("/maps/gymbrohouse.txt", 9);
        loadMap("/maps/scientisthouse.txt", 10);
        loadMap("/maps/farmerhouse.txt", 11);
        loadMap("/maps/presidenthouse.txt", 12);
        loadMap("/maps/scouthouse.txt", 13);
        loadMap("/maps/fishermanhouse.txt", 14);
        loadMap("/maps/thiefhouse.txt", 15);
        loadMap("/maps/woodcutterhouse.txt", 16);
        loadMap("/maps/elderhouse.txt", 17);
        loadMap("/maps/shopkeeperhouse.txt", 18);
        loadMap("/maps/desert01.txt", 19);
        loadMap("/maps/chieftent.txt", 20);
        loadMap("/maps/playerhouse.txt", 21);
        loadMap("/maps/abandonhouse.txt", 22);
        loadMap("/maps/deserttemple01.txt", 23);
        loadMap("/maps/barn.txt", 24);
        loadMap("/maps/woodcave.txt", 25);
    }

    public void getTileImages() {
        // Predefine collision rules using a boolean array
        boolean[] collisionFlags = new boolean[898];

        // Default all to true
        Arrays.fill(collisionFlags, false);
        
        // Set specific indices to false
        collisionFlags[0] = true; //water
        collisionFlags[10] = true; //cliff
        collisionFlags[11] = true; //cliff
        collisionFlags[12] = true; //cliff
        collisionFlags[13] = true; //cliff
        collisionFlags[15] = true; //cliff
        collisionFlags[16] = true; //cliff
        collisionFlags[17] = true; //cliff
        collisionFlags[18] = true; //cliff
        collisionFlags[19] = true; //cliff
        collisionFlags[20] = true; //cliff
        collisionFlags[21] = true; //cliff
        collisionFlags[22] = true; //cliff
        collisionFlags[55] = true; //water
        collisionFlags[56] = true; //water
        collisionFlags[57] = true; //water
        collisionFlags[89] = true; //blank
        collisionFlags[134] = true; //cliff
        collisionFlags[136] = true; //cliff
        collisionFlags[137] = true; //cliff
        collisionFlags[138] = true; //cliff
        collisionFlags[143] = true; //cliff
        collisionFlags[144] = true; //cliff
        collisionFlags[145] = true; //cliff
        collisionFlags[152] = true; //cliff
        collisionFlags[153] = true; //cliff
        collisionFlags[154] = true; //cliff
        collisionFlags[159] = true; //cliff
        collisionFlags[160] = true; //cliff
        collisionFlags[161] = true; //cliff
        collisionFlags[193] = true; //bridge
        collisionFlags[194] = true; //bridge
        collisionFlags[195] = true; //bridge
        collisionFlags[196] = true; //bridge
        collisionFlags[197] = true; //bridge
        collisionFlags[198] = true; //bridge
        collisionFlags[199] = true; //bridge
        collisionFlags[200] = true; //bridge
        collisionFlags[206] = true; //bridge
        collisionFlags[207] = true; //bridge
        collisionFlags[208] = true; //bridge
        collisionFlags[209] = true; //bridge
        collisionFlags[252] = true; //cliff
        collisionFlags[253] = true; //cliff
        collisionFlags[254] = true; //cliff
        collisionFlags[259] = true; //cliff
        collisionFlags[260] = true; //cliff
        collisionFlags[261] = true; //cliff
        collisionFlags[264] = true; //cliff
        collisionFlags[265] = true; //cliff
        collisionFlags[266] = true; //cliff
        collisionFlags[267] = true; //cliff
        collisionFlags[270] = true; //cliff
        collisionFlags[271] = true; //cliff
        collisionFlags[272] = true; //cliff
        collisionFlags[273] = true; //cliff
        collisionFlags[280] = true; //cliff
        collisionFlags[281] = true; //cliff
        
        collisionFlags[287] = true; //dungeon
        collisionFlags[288] = true; //dungeon
        collisionFlags[289] = true; //dungeon
        collisionFlags[290] = true; //dungeon
        collisionFlags[296] = true; //dungeon
        collisionFlags[297] = true; //dungeon
        collisionFlags[298] = true; //dungeon
        collisionFlags[305] = true; //dungeon
        collisionFlags[306] = true; //dungeon
        collisionFlags[307] = true; //dungeon
        collisionFlags[308] = true; //dungeon
        collisionFlags[316] = true; //dungeon
        collisionFlags[317] = true; //dungeon
        collisionFlags[318] = true; //dungeon
        collisionFlags[319] = true; //dungeon
        collisionFlags[326] = true; //dungeon
        collisionFlags[327] = true; //dungeon
        collisionFlags[328] = true; //dungeon
        collisionFlags[329] = true; //dungeon
        collisionFlags[333] = true; //dungeon
        collisionFlags[334] = true; //dungeon
        collisionFlags[335] = true; //dungeon
        collisionFlags[336] = true; //dungeon
        
        collisionFlags[364] = true; //dungeon
//        collisionFlags[365] = true; //dungeon
//        collisionFlags[366] = true; //dungeon
//        collisionFlags[367] = true; //dungeon
        collisionFlags[368] = true; //dungeon
        collisionFlags[372] = true; //dungeon
        collisionFlags[373] = true; //dungeon
        collisionFlags[374] = true; //dungeon
//        collisionFlags[376] = true; //dungeon
        collisionFlags[380] = true; //dungeon
        collisionFlags[382] = true; //dungeon
        collisionFlags[383] = true; //dungeon
        collisionFlags[384] = true; //dungeon
        collisionFlags[386] = true; //dungeon
        collisionFlags[390] = true; //dungeon
        collisionFlags[392] = true; //dungeon
        collisionFlags[393] = true; //dungeon
        collisionFlags[394] = true; //dungeon
        collisionFlags[396] = true; //dungeon
        collisionFlags[400] = true; //dungeon
        collisionFlags[406] = true; //dungeon
        collisionFlags[407] = true; //dungeon
        collisionFlags[408] = true; //dungeon
        collisionFlags[409] = true; //dungeon
        collisionFlags[410] = true; //dungeon
        collisionFlags[413] = true; //dungeon
        collisionFlags[414] = true; //dungeon
        collisionFlags[415] = true; //dungeon
        
        collisionFlags[416] = true; //fence
        collisionFlags[417] = true; //fence
        collisionFlags[418] = true; //fence
        collisionFlags[419] = true; //fence
        collisionFlags[420] = true; //fence
        collisionFlags[421] = true; //fence
        collisionFlags[422] = true; //fence
        collisionFlags[423] = true; //fence
        collisionFlags[424] = true; //fence
        collisionFlags[425] = true; //fence
        collisionFlags[426] = true; //fence
        collisionFlags[427] = true; //fence
        collisionFlags[428] = true; //fence
        collisionFlags[429] = true; //fence
        collisionFlags[430] = true; //fence
        collisionFlags[431] = true; //fence
        
        for (int i = 436; i <= 493; i++) {
            collisionFlags[i] = true; // Mark as wall
        }
        
        collisionFlags[526] = true; //Grass (to hide behind houses)
        
        collisionFlags[527] = true; //palisade
        collisionFlags[528] = true; //palisade
        collisionFlags[529] = true; //palisade
        collisionFlags[532] = true; //palisade
        collisionFlags[533] = true; //palisade
        collisionFlags[534] = true; //palisade
        collisionFlags[537] = true; //palisade
        collisionFlags[538] = true; //palisade
        collisionFlags[541] = true; //palisade
        collisionFlags[542] = true; //palisade
        collisionFlags[543] = true; //palisade
        collisionFlags[546] = true; //palisade
        collisionFlags[547] = true; //palisade
        collisionFlags[548] = true; //palisade
        collisionFlags[550] = true; //palisade
        collisionFlags[551] = true; //palisade
        collisionFlags[552] = true; //palisade
        collisionFlags[553] = true; //palisade
        collisionFlags[555] = true; //palisade
        collisionFlags[557] = true; //palisade
        collisionFlags[560] = true; //palisade
        collisionFlags[562] = true; //palisade
        collisionFlags[569] = true; //palisade
        collisionFlags[570] = true; //palisade
        collisionFlags[571] = true; //palisade
        collisionFlags[574] = true; //palisade
        collisionFlags[575] = true; //palisade
        collisionFlags[576] = true; //palisade
        collisionFlags[579] = true; //palisade
        collisionFlags[580] = true; //palisade
        collisionFlags[583] = true; //palisade
        collisionFlags[584] = true; //palisade
        collisionFlags[585] = true; //palisade
        collisionFlags[588] = true; //palisade
        collisionFlags[589] = true; //palisade
        collisionFlags[590] = true; //palisade
        collisionFlags[592] = true; //palisade
        collisionFlags[593] = true; //palisade
        collisionFlags[594] = true; //palisade
        collisionFlags[595] = true; //palisade
        
        collisionFlags[611] = true; //desert
        collisionFlags[612] = true; //desert
        collisionFlags[613] = true; //desert
        collisionFlags[616] = true; //desert
        collisionFlags[618] = true; //desert
        collisionFlags[621] = true; //desert
        collisionFlags[622] = true; //desert
        collisionFlags[623] = true; //desert
        collisionFlags[637] = true; //desert
        collisionFlags[646] = true; //desert
        collisionFlags[647] = true; //desert
        collisionFlags[648] = true; //desert
        collisionFlags[653] = true; //desert
        collisionFlags[654] = true; //desert
        
        collisionFlags[661] = true; //desert
        collisionFlags[662] = true; //desert
        collisionFlags[663] = true; //desert
        collisionFlags[664] = true; //desert
        collisionFlags[665] = true; //desert

        collisionFlags[670] = true; //desert
        collisionFlags[671] = true; //desert
        collisionFlags[672] = true; //desert
        collisionFlags[673] = true; //desert
        collisionFlags[674] = true; //desert
        collisionFlags[675] = true; //desert
        collisionFlags[676] = true; //desert
        collisionFlags[677] = true; //desert
        collisionFlags[742] = true; //desert
        collisionFlags[743] = true; //desert
        collisionFlags[744] = true; //desert
        collisionFlags[745] = true; //desert
        collisionFlags[746] = true; //desert
        collisionFlags[747] = true; //desert
        
        collisionFlags[754] = true; //tent
        collisionFlags[755] = true; //tent
        collisionFlags[756] = true; //tent
        collisionFlags[757] = true; //tent
        collisionFlags[758] = true; //tent
        collisionFlags[759] = true; //tent

        for (int i = 770; i <= 785; i++) {
            collisionFlags[i] = true; // Desert fence
        }
        for (int i = 786; i <= 797; i++) {
            collisionFlags[i] = true; // Desert temple
        }
        
        collisionFlags[816] = true; //Sand (to hide behind houses)
        
        collisionFlags[847] = true; //Wood Cave
        collisionFlags[848] = true; //Wood Cave
        collisionFlags[849] = true; //Wood Cave
        collisionFlags[852] = true; //Wood Cave
        collisionFlags[853] = true; //Wood Cave
        collisionFlags[857] = true; //Wood Cave
        collisionFlags[858] = true; //Wood Cave
        collisionFlags[859] = true; //Wood Cave
        collisionFlags[862] = true; //Wood Cave
        collisionFlags[863] = true; //Wood Cave
        collisionFlags[866] = true; //Wood Cave
        collisionFlags[867] = true; //Wood Cave
        
        for (int i = 868; i <= 877 ; i++) {
            collisionFlags[i] = true; //Wood Cave
        }
        
        collisionFlags[880] = true; //Wood Cave
        

        for (int i = 0; i < collisionFlags.length; i++) {
            setup(i, String.format("%04d", i), collisionFlags[i]);
        }
    }
    
    public void setup(int index, String imagePath, boolean collision) {
    	
    	UtilityTool uTool = new UtilityTool();
    	
    	try {
    		tile[index] = new Tile();
    		tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imagePath + ".png"));
    		tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
    		tile[index].collision = collision;
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    

    public void loadMap(String filePath, int map) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[map][col][row] = num;
                    col++;
                }

                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            // Optimization: Render only visible tiles
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                // Draw the tile image
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                
                if (gp.keyH.showDebugText) {
                    // Highlight collision tiles with a semi-transparent red overlay
                    if (tile[tileNum].collision) {
                        g2.setColor(new Color(255, 0, 0, 100));
                        g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
                    }
                    
                    // Use translucent white text for the tile number
                    g2.setColor(new Color(255, 255, 255, 100));
                    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 7)); // Use current font, set to size 14
                    
                    // Approximate centering manually
                    int textX = screenX + gp.tileSize / 4 + 4; // Rough horizontal centering
                    int textY = screenY + (gp.tileSize / 2) + 4; // Adjust for vertical centering
                    g2.drawString(String.valueOf(tileNum), textX, textY);
                }
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }

        // Pathfinding visualization (if enabled)
        if (drawPath && gp.keyH.showDebugText) {
            g2.setColor(new Color(255, 0, 0, 70));
            for (int i = 0; i < gp.pFinder.pathList.size(); i++) {
                int worldX = gp.pFinder.pathList.get(i).col * gp.tileSize;
                int worldY = gp.pFinder.pathList.get(i).row * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;

                g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
            }
        }
    }
}
    