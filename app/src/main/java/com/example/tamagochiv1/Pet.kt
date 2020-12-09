import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class Pet(name: String, skin: String) {
     private var name: String = "Name";
     private var happiness: Int = 20;
     private var hunger: Int = 20
     private var energy: Int = 20;
     private var hygiene: Int = 20;
     private var hitpoints : Int = 100;
     private var skin: String = "Boxie";
//     private var age: null;

     init{
//          this.age = LocalDateTime.now();
          this.name = name;
          this.skin = skin;
     }

// --------------------------------------------------------------------- //
// -------------------------------- SET -------------------------------- //
// --------------------------------------------------------------------- //

     public fun setName(name: String){
          this.name = name;
     }

     public fun setHappyness(happiness: Int){
          this.happiness = happiness
     }

     public fun setHunger(hunger: Int){
          this.hunger = hunger
     }

     public fun setEnergy(energy: Int){
          this.energy = energy
     }

     public fun setHygiene(hygiene: Int){
          this.hygiene = hygiene
     }

     public fun setHitpoints(hp: Int){
          this.hitpoints = hp
     }

     public fun setSkin(skin: String){
          this.skin = skin
     }

// --------------------------------------------------------------------- //
// -------------------------------- GET -------------------------------- //
// --------------------------------------------------------------------- //
     public fun getName() :String{
          return(this.name)
     }

     public fun getHappiness() :Int{
          return (this.happiness)
     }

     public fun getHunger() :Int{
          return (this.hunger)
     }

     public fun getEnergy() :Int{
          return (this.energy)
     }

     public fun getHygiene() :Int{
          return (this.hygiene)
     }

     public fun getHitpoints() :Int{
          return (this.hitpoints)
     }

     public fun getSkin() :String{
          return (this.skin)
     }

// --------------------------------------------------------------------- //
// -------------------------------- ADD -------------------------------- //
// --------------------------------------------------------------------- //
     public fun addHappiness(add : Int){
          if((this.happiness+add) > 100) {
               this.happiness = this.happiness + add
          }
     }

     public fun addHunger (add : Int) {
          if((this.hunger+add) > 100) {
               this.hunger = this.hunger + add
          }
     }

     public fun addEnergy (add : Int) {
          if((this.energy+add) > 100) {
               this.energy = this.energy + add
          }
     }

     public fun addHygiene (add : Int) {
          if((this.hygiene+add) > 100) {
               this.hygiene = this.hygiene + add
          }
     }

     public fun addHitpoints (add : Int) {
          if((this.hitpoints+add) > 100) {
               this.hitpoints = this.hitpoints + add
          }
     }

// --------------------------------------------------------------------- //
// -------------------------------- SUB -------------------------------- //
// --------------------------------------------------------------------- //

     public fun subHappiness(sub : Int){
          if((this.happiness - sub) < 0) {
               this.happiness = this.happiness - sub
          }
     }

     public fun subHunger (sub : Int) {
          if((this.hunger - sub) > 0) {
               this.hunger = this.hunger - sub
          }
     }

     public fun subEnergy (sub : Int) {
          if((this.energy - sub) > 0) {
               this.energy = this.energy - sub
          }
     }

     public fun subHygiene (sub : Int) {
          if((this.hygiene - sub) > 0) {
               this.hygiene = this.hygiene - sub
          }
     }

     public fun subHitpoints (sub : Int) {
          if((this.hitpoints - sub) > 0) {
               this.hitpoints = this.hitpoints - sub
          }
     }

}