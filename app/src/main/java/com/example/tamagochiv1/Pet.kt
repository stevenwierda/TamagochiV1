import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.tamagochiv1.CreatePet
import com.example.tamagochiv1.SaveDataManager
import java.io.Serializable

class Pet(name: String, skin: String): Serializable{
     private var name: String = "Name";
     private var happiness: Int = 20;
     private var hunger: Int = 20
     private var energy: Int = 20;
     private var hygiene: Int = 20;
     private var hitpoints : Int = 100;
     private var skin: String = "Boxie";

     init{
          this.name = name;
          this.skin = skin;
     }

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
     //          setHappyness(((getHappyness() + 10) * 0.4).toInt())
          this.hygiene = hygiene
     }

     public fun setHitpoints(hp: Int){
          this.hitpoints = hp
     }

     public fun setSkin(skin: String){
          this.skin = skin
     }

     public fun getName() :String{
          return(this.name)
     }

     public fun getHappyness() :Int{
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

     public fun addHappiness(add : Int){
          if((this.happiness+add) > this.happiness) {
               this.happiness = this.happiness + add
          }
     }


}
