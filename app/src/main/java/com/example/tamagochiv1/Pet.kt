import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
class Pet(name: String, skin: String) {

     private val TAG = Pet::class.java.simpleName


     private var name: String = "Name";
     private var happiness: Float = 70f
     private var hunger: Float = 50f
     private var energy: Float = 100f
     private var hygiene: Float = 50f
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

     public fun setHappyness(happiness: Float){
//          Log.d(TAG, "setHappyness(): ${happiness}")
          this.happiness = happiness
     }

     public fun setHunger(hunger: Float){
//          Log.d(TAG, "setHunger(): ${hunger}")
          this.hunger = hunger
     }

     public fun setEnergy(energy: Float){
//          Log.d(TAG, "setEnergy(): ${energy}")
          this.energy = energy
     }

     public fun setHygiene(hygiene: Float){
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

     public fun getHappiness() : Float{
//          Log.d(TAG, "getHappiness(): ${this.happiness}")
          return (this.happiness)
     }

     public fun getHunger() : Float{
//          Log.d(TAG, "getHunger(): ${this.hunger}")
          return (this.hunger)
     }

     public fun getEnergy() : Float{
//          Log.d(TAG, "getEnergy(): ${this.energy}")
          return (this.energy)
     }

     public fun getHygiene() : Float{
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
     public fun addHappiness(add : Float) {
//          Log.d(TAG, "addHappiness(): ${add}")
          if((this.happiness + add) < 100) {
               this.happiness = this.happiness + add
          } else {
               this.happiness = 100f
          }
     }

     public fun addHunger (add : Float) {
//          Log.d(TAG, "addHunger(): ${add}")
          if((this.hunger + add) < 100) {
               this.hunger = this.hunger + add
          } else {
               this.hunger = 100f
          }
     }

     public fun addEnergy (add : Float) {
//          Log.d(TAG, "addEnergy(): ${add}")
          if((this.energy + add) < 100) {
               this.energy = this.energy + add
          } else {
               this.energy = 100f
          }
     }

     public fun addHygiene (add : Float) {
//          Log.d(TAG, "addHygiene(): ${add}")
          if((this.hygiene + add) < 100) {
               this.hygiene = this.hygiene + add
          } else {
               this.hygiene = 100f
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

     public fun subHappiness(sub : Float, timeDiff : Long = 0){
          Log.d(TAG, "subHappiness(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeHappiness
               this.happiness = this.happiness - toSub.toInt()
          } else {
               if((this.happiness - sub) > 0) {
                    this.happiness = this.happiness - sub
               } else {
                    this.happiness = 0f
               }
          }


     }

     public fun subHunger (sub : Float, timeDiff : Long = 0) {
          Log.d(TAG, "subHunger(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeHunger
               this.hunger = this.hunger - toSub.toInt()
          } else {
               if ((this.hunger - sub) > 0) {
                    this.hunger = this.hunger - sub
               } else {
                    this.hunger = 0f
               }
          }
     }

     public fun subEnergy (sub : Float, timeDiff : Long = 0) {
          Log.d(TAG, "subEnergy(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeEnergy
               this.energy = this.energy - toSub.toInt()
          } else {
               if ((this.energy - sub) > 0) {
                    this.energy = this.energy - sub
               } else {
                    this.energy = 0f
               }
          }
     }

     public fun subHygiene (sub : Float, timeDiff : Long = 0) {
          Log.d(TAG, "subHygiene(): ${sub} whit time: ${timeDiff}")
          if (timeDiff > 0) {
               var toSub = 100 * timeDiff / timeHygiene
               this.hygiene = this.hygiene - toSub.toInt()
          } else {
               if ((this.hygiene - sub) > 0) {
                    this.hygiene = this.hygiene - sub
               } else {
                    this.hygiene = 0f
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