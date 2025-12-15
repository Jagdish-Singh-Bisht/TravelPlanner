package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class UttarakhandPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerPlaces;
    ArrayList<Place> placesList;
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uttarakhand_places);

        Toolbar toolbar = findViewById(R.id.placesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerPlaces = findViewById(R.id.recyclerPlaces);
        placesList = new ArrayList<>();

        // -------------------------------------------------------------
        // 1️⃣ RISHIKESH — Things List
        ArrayList<ThingItem> rishikeshThings = new ArrayList<>();
        rishikeshThings.add(new ThingItem(R.drawable.ic_rafting, "River Rafting",
                "Adventure rafting on Ganga", "Route: Shivpuri → Rishikesh",
                "Best Time: Oct–June", "Duration: 1–2 hours"));

        rishikeshThings.add(new ThingItem(R.drawable.ic_aarti, "Ganga Aarti",
                "Evening prayer ritual", "Location: Triveni Ghat",
                "Best Time: Sunset", "Entry: Free"));

        rishikeshThings.add(new ThingItem(R.drawable.ic_yoga, "Yoga Sessions",
                "Yoga capital of India", "Morning riverside classes",
                "Ashrams near Ram Jhula", "Best Time: 6–8 AM"));


        placesList.add(new Place(
                "Rishikesh",
                R.drawable.rishikesh,
                "Yoga Capital of the World · River rafting · Ganga Aarti at Triveni Ghat.",
                "September to November · March to May",
                rishikeshThings,
                "Aloha on the Ganges, Live Free Hostel, Ganga Kinare",
                "Yoga, Meditation, Rafting, Spirituality",
                30.0869, 78.2676
        ));

        // -------------------------------------------------------------
        // 2️⃣ MUSSOORIE — Things List
        ArrayList<ThingItem> mussoorieThings = new ArrayList<>();
        mussoorieThings.add(new ThingItem(R.drawable.ic_waterfall, "Kempty Falls",
                "Most famous waterfall", "Great for photos & bathing",
                "Best Time: Morning", "Crowded on weekends"));

        mussoorieThings.add(new ThingItem(R.drawable.ic_viewpoint, "Lal Tibba",
                "Highest viewpoint", "Amazing Himalayan views",
                "Morning sunrise recommended", "Entry ₹50"));

        mussoorieThings.add(new ThingItem(R.drawable.ic_ropeway, "Gun Hill Ropeway",
                "Cable car ride", "Short & scenic ride",
                "Best Time: Evening", "Great for photographers"));


        placesList.add(new Place(
                "Mussoorie",
                R.drawable.mussoorie,
                "Queen of Hills with waterfalls, viewpoints, colonial charm.",
                "April to June · September to November",
                mussoorieThings,
                "JW Marriott, Rokeby Manor, Hotel Vishnu Palace",
                "Hills, Trek, Waterfalls, Ropeway",
                30.4547, 78.0710
        ));

        // -------------------------------------------------------------
        // 3️⃣ NAINITAL — Things List
        ArrayList<ThingItem> nainitalThings = new ArrayList<>();
        nainitalThings.add(new ThingItem(R.drawable.ic_boat, "Boating in Naini Lake",
                "Peaceful lake boating", "Paddle & row boats available",
                "Best Time: Evening", "Charges: ₹200–₹400"));

        nainitalThings.add(new ThingItem(R.drawable.ic_trek, "Naina Peak",
                "Highest peak of Nainital", "Easy–moderate trek",
                "Duration: 1–2 hrs", "Best for sunrise"));

        nainitalThings.add(new ThingItem(R.drawable.ic_cave, "Eco Cave Gardens",
                "Natural caves for kids", "Musical fountain show",
                "Best Time: Afternoon", "Entry ₹60"));


        placesList.add(new Place(
                "Nainital",
                R.drawable.nainital,
                "Beautiful lakeside town featuring boating and Himalayan viewpoints.",
                "March to June · October to December",
                nainitalThings,
                "Manu Maharani, Seasons Resort, Nainital Palace",
                "Boating, Lakes, Trekking",
                29.3919, 79.4542
        ));

        // -------------------------------------------------------------
        // 4️⃣ DEHRADUN — Things List
        ArrayList<ThingItem> dehradunThings = new ArrayList<>();
        dehradunThings.add(new ThingItem(R.drawable.ic_cave_doon, "Robber's Cave",
                "Natural cave stream", "Walk inside flowing water",
                "Popular picnic spot", "Parking available"));

        dehradunThings.add(new ThingItem(R.drawable.ic_museum, "FRI Museum",
                "Historic colonial architecture", "Educational museum",
                "Huge photography spot", "Entry ₹40"));

        dehradunThings.add(new ThingItem(R.drawable.ic_temple, "Tapkeshwar Temple",
                "Lord Shiva temple", "Water dripping cave",
                "Best Time: Morning", "Free entry"));


        placesList.add(new Place(
                "Dehradun",
                R.drawable.dehradun,
                "Capital city known for caves, waterfalls, and forest research institute.",
                "March to June",
                dehradunThings,
                "Lemon Tree, Hotel Saffron Leaf, Clarion Hotel",
                "Caves, Waterfalls, Museum",
                30.3165, 78.0322
        ));

        // -------------------------------------------------------------
        // 5️⃣ JIM CORBETT — Things List
        ArrayList<ThingItem> corbettThings = new ArrayList<>();
        corbettThings.add(new ThingItem(R.drawable.ic_safari, "Jeep Safari",
                "Most popular activity", "Chance to spot tigers",
                "Zones: Bijrani, Dhikala", "Book online early"));

        corbettThings.add(new ThingItem(R.drawable.ic_bird, "Bird Watching",
                "Over 500 species", "Best Time: Morning",
                "Dhikala best zone", "Binocular recommended"));

        corbettThings.add(new ThingItem(R.drawable.ic_temple_corbett, "Garjia Temple",
                "Famous riverside temple", "Beautiful bridge walk",
                "Best Time: Evening", "Free entry"));


        placesList.add(new Place(
                "Jim Corbett",
                R.drawable.corbett,
                "India’s oldest national park known for tigers and safaris.",
                "November to February",
                corbettThings,
                "Corbett Riverside, Tiger Camp, Taj Corbett Resort",
                "Safari, Wildlife, Forest",
                29.5300, 78.7740
        ));

        // -------------------------------------------------------------
        // 6️⃣ AULI — Things List
        ArrayList<ThingItem> auliThings = new ArrayList<>();
        auliThings.add(new ThingItem(R.drawable.ic_skiing, "Skiing",
                "Best snow slopes in India", "Training available",
                "Best Time: Jan–Feb", "Equipment rentable"));

        auliThings.add(new ThingItem(R.drawable.ic_ropeway_auli, "Auli Ropeway",
                "Asia’s longest ropeway", "Views of Nanda Devi",
                "Duration: 25 minutes", "Tickets ₹1000 approx"));

        auliThings.add(new ThingItem(R.drawable.ic_trek_auli, "Gorson Bugyal Trek",
                "Easy meadow trek", "Great winter snow trek",
                "Best Time: Morning", "Duration 2–3 hours"));


        placesList.add(new Place(
                "Auli",
                R.drawable.auli,
                "Snowy ski destination with ropeway and breathtaking Himalayan views.",
                "December to February (snow) · March to June (pleasant)",
                auliThings,
                "Blue Poppy Resort, Clifftop Club, Kuber Resort",
                "Snow, Skiing, Ropeway",
                30.5286, 79.5712
        ));

        // -------------------------------------------------------------
        // 7️⃣ KEDARNATH — Things List
        ArrayList<ThingItem> kedarnathThings = new ArrayList<>();
        kedarnathThings.add(new ThingItem(R.drawable.ic_temple_kedar, "Kedarnath Temple",
                "12 Jyotirlinga", "Main pilgrimage site",
                "Must reach early", "Opens May to Oct"));

        kedarnathThings.add(new ThingItem(R.drawable.ic_trek_kedar, "Vasuki Tal Trek",
                "Scenic lake trek", "Moderate difficulty",
                "Best Time: Morning", "Requires guide"));

        kedarnathThings.add(new ThingItem(R.drawable.ic_temple_kedar, "Bhairavnath Temple",
                "Short uphill trek", "Amazing valley views",
                "Best Time: Sunset", "Free entry"));


        placesList.add(new Place(
                "Kedarnath",
                R.drawable.kedarnath,
                "Sacred Shiva temple located amid Himalayan mountains.",
                "May to June · September to October",
                kedarnathThings,
                "GMVN Kedarnath, Sitapur Lodges, Sonprayag Stay",
                "Pilgrimage, Trekking, Temple",
                30.7346, 79.0669
        ));

        // -------------------------------------------------------------
        // 8️⃣ VALLEY OF FLOWERS — Things List
        ArrayList<ThingItem> vofThings = new ArrayList<>();
        vofThings.add(new ThingItem(R.drawable.ic_trek_valley, "Valley Trek",
                "Main valley trek", "Beautiful meadows",
                "Best Time: July–Aug", "Starts from Ghangaria"));

        vofThings.add(new ThingItem(R.drawable.ic_trek_valley, "Hemkund Sahib Trek",
                "Pilgrimage trek", "Steep climb",
                "Best Time: Morning", "Opens June–Oct"));

        vofThings.add(new ThingItem(R.drawable.ic_camera, "Photography",
                "Heaven for photographers", "Flowers bloom July–Sept",
                "Carry raincoat", "Avoid slippery areas"));


        placesList.add(new Place(
                "Valley of Flowers",
                R.drawable.valleyflowers,
                "UNESCO heritage valley blooming with seasonal flowers.",
                "July to September",
                vofThings,
                "Hotels in Ghangaria, GMVN Guest Houses",
                "Trek, Nature, Valley",
                30.7280, 79.6050
        ));

        // -------------------------------------------------------------
        // 9️⃣ TUNGNATH — Things List
        ArrayList<ThingItem> tungnathThings = new ArrayList<>();
        tungnathThings.add(new ThingItem(R.drawable.ic_temple_tungnath, "Tungnath Temple",
                "Highest Shiva temple", "Trek 3.5 km from Chopta",
                "Easy–moderate trek", "Best Time: Early morning"));

        tungnathThings.add(new ThingItem(R.drawable.ic_trek_tungnath, "Chandrashila Trek",
                "Summit with 360° views", "Snow in winter",
                "Best Time: Sunrise", "Carry warm clothes"));

        tungnathThings.add(new ThingItem(R.drawable.ic_snow, "Snow Trek",
                "Winter snow trail", "Requires proper shoes",
                "Best Time: Jan–Feb", "Moderate difficulty"));


        placesList.add(new Place(
                "Tungnath",
                R.drawable.tungnath,
                "World’s highest Shiva temple · gateway to Chandrashila peak.",
                "April to June · September to November",
                tungnathThings,
                "Chopta Camps, Magpie Camp, Snow View Resort",
                "Temple, Trek, Snow",
                30.4900, 79.2100
        ));

        // Attach Adapter
        adapter = new PlaceAdapter(this, placesList);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerPlaces.setAdapter(adapter);
    }
}
