import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
class Pet(name: String, skin: String) {

     private val TAG = Pet::class.java.simpleName


     private var name: String = "Name";
     private var happiness: Int = 70;
     private var hunger: Int = 50
     private var energy: Int = 100;
     private var hygiene: Int = 50;
     private var hitpoints : Int = 100;
     private var skin: String = "Boxie";
//     private var age: null;





     // The time that the Tamgotchi can without
     private val timeHappiness = 604800
     private val timeHunger = 259200
     private val timeEnergy = 129600
     private val timeHygiene = 1036800



     init{
//          this.age = LocalDateTime.now();
          this.name = name;
          this.skin = skin;
     }

// --------------------------------------------------------------------- //
// -------------------------------- SET -------------------------------- //
// --------------------------------------------------------------------- //

     public fun setName(name: String){
//          Log.d(TAG, "setName(): ${name}")
          this.name = name;
     }

     public fun setHappyness(happiness: Int){
//          Log.d(TAG, "setHappyness(): ${happiness}")
          this.happiness = happiness
     }

     public fun setHunger(hunger: Int){
//          Log.d(TAG, "setHunger(): ${hunger}")
          this.hunger = hunger
     }

     public fun setEnergy(energy: Int){
//          Log.d(TAG, "setEnergy(): ${energy}")
          this.energy = energy
     }

     public fun setHygiene(hygiene: Int){
//          Log.d(TAG, "setHygiene(): ${hygiene}")
          this.hygiene = hygiene
     }

     public fun setHitpoints(hp: Int){
//          Log.d(TAG, "setHitpoints(): ${hp}")
          this.hitpoints = hp
     }

     public fun setSkin(skin: String){
//          Log.d(TAG, "setSkin(): ${skin}")
          this.skin = skin
     }

     // --------------------------------------------------------------------- //
// -------------------------------- GET -------------------------------- //
// --------------------------------------------------------------------- //
     public fun getName() :String{
//          Log.d(TAG, "getName(): ${this.name}")
          return(this.name)
     }

     public fun getHappiness() :Int{
//          Log.d(TAG, "getHappiness(): ${this.happiness}")
          return (this.happiness)
     }

     public fun getHunger() :Int{
//          Log.d(TAG, "getHunger(): ${this.hunger}")
          return (this.hunger)
     }

     public fun getEnergy() :Int{
//          Log.d(TAG, "getEnergy(): ${this.energy}")
          return (this.energy)
     }

     public fun getHygiene() :Int{
//          Log.d(TAG, "getHygiene(): ${this.hunger}")
          return (this.hygiene)
     }

     public fun getHitpoints() :Int{
//          Log.d(TAG, "getHitpoints(): ${this.hitpoints}")
          return (this.hitpoints)
     }

     public fun getSkin() :String{
//          Log.d(TAG, "getSkin(): ${this.skin}")
          return (this.skin)
     }

     // --------------------------------------------------------------------- //
// -------------------------------- ADD -------------------------------- //
// --------------------------------------------------------------------- //
     public fun addHappiness(add : Int) {
//          Log.d(TAG, "addHappiness(): ${add}")
          if((this.happiness + add) < 100) {
               this.happiness = this.happiness + add
          } else {
               this.happiness = 100
          }
     }

     public fun addHunger (add : Int) {
//          Log.d(TAG, "addHunger(): ${add}")
          if((this.hunger + add) < 100) {
               this.hunger = this.hunger + add
          } else {
               this.hunger = 100
          }
     }

     public fun addEnergy (add : Int) {
//          Log.d(TAG, "addEnergy(): ${add}")
          if((this.energy + add) < 100) {
               this.energy = this.energy + add
          } else {
               this.energy = 100
          }
     }

     public fun addHygiene (add : Int) {
//          Log.d(TAG, "addHygiene(): ${add}")
          if((this.hygiene + add) < 100) {
               this.hygiene = this.hygiene + add
          } else {
               this.hygiene = 100
          }
     }

     public fun addHitpoints (add : Int) {
//          Log.d(TAG, "addHitpoints(): ${add}")
          if((this.hitpoints + add) < 100) {
               this.hitpoints = this.hitpoints + add
          } else {
               this.hitpoints = 100
          }
     }

// --------------------------------------------------------------------- //
// -------------------------------- SUB -------------------------------- //
// --------------------------------------------------------------------- //

     public fun subHappiness(sub : Int, timeDiff : Long = 0){
          Log.d(TAG, "subHappiness(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeHappiness
               this.happiness = this.happiness - toSub.toInt()
          } else {
               if((this.happiness - sub) > 0) {
                    this.happiness = this.happiness - sub
               } else {
                    this.happiness = 0
               }
          }


     }

     public fun subHunger (sub : Int, timeDiff : Long = 0) {
          Log.d(TAG, "subHunger(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeHunger
               this.hunger = this.hunger - toSub.toInt()
          } else {
               if ((this.hunger - sub) > 0) {
                    this.hunger = this.hunger - sub
               } else {
                    this.hunger = 0
               }
          }
     }

     public fun subEnergy (sub : Int, timeDiff : Long = 0) {
          Log.d(TAG, "subEnergy(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeEnergy
               this.energy = this.energy - toSub.toInt()
          } else {
               if ((this.energy - sub) > 0) {
                    this.energy = this.energy - sub
               } else {
                    this.energy = 0
               }
          }
     }

     public fun subHygiene (sub : Int, timeDiff : Long = 0) {
          Log.d(TAG, "subHygiene(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeHygiene
               this.hygiene = this.hygiene - toSub.toInt()
          } else {
               if ((this.hygiene - sub) > 0) {
                    this.hygiene = this.hygiene - sub
               } else {
                    this.hygiene = 0
               }
          }
     }

     public fun subHitpoints (sub : Int, timeDiff : Long = 0) {
          Log.d(TAG, "subHitpoints(): ${sub} whit time: ${timeDiff}")
          if((this.hitpoints - sub) > 0) {
               this.hitpoints = this.hitpoints - sub
          } else {
               this.hitpoints = 0
          }
     }

}