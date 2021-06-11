package funix.prm391.tourguidever3;
import funix.prm391.tourguidever3.adapter.OptionsAdapter;
import funix.prm391.tourguidever3.objectmodel.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private Province province = initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main,container,false);

        //Set adapter for Options
        GridView optionGridView = rootView.findViewById(R.id.options_gridview);
        OptionsAdapter adapter = new OptionsAdapter(getActivity(), province.getmOptionArrayList());
        optionGridView.setAdapter(adapter);

        //Set ClickListener for Options
        optionGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Option selectedOption = province.getmOptionArrayList().get(position);

                //Pass selectedOption through fragments
                Bundle bundle = new Bundle();
                bundle.putParcelable("OPTION", selectedOption);
                Fragment destFragment = new DestinationFragment();
                destFragment.setArguments(bundle);

                getParentFragmentManager().beginTransaction().replace(R.id.fragment_switcher,destFragment).addToBackStack(null).commit();


            }
        });
        return rootView;
    }

    private Province initData(){
        Province province = new Province(R.drawable.vietnam,"Hà Nội");

        //init Options
        Option atm = new Option(R.drawable.atm_machine,"ATM");
        Option hospital = new Option(R.drawable.hospital, "Hospital");
        Option hotel = new Option(R.drawable.hotel,"Hotel");
        Option bus = new Option(R.drawable.metro, "Bus");

        //init data for Options
        atm.addDestination("ATM Hoàn Kiếm", "25 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội", 21.0217558,105.8559817);
        atm.addDestination("ATM Đinh Tiên Hoàng", "7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội" , 21.0319681,105.8503201);
        atm.addDestination("ATM Hội sở", "57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội", 21.0237307,105.8460968);
        atm.addDestination("ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội", 21.00202,105.8404923);
        atm.addDestination("ATM Hai Bà Trưng","300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội", 21.0083989,105.8424435);
        atm.addDestination("ATM Lê Ngọc Hân", "44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội", 21.0160284,105.8529619);
        atm.addDestination("ATM Thăng Long", "129-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội", 21.04646,105.7840913);
        atm.addDestination("ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội", 21.030852,105.7806293);
        atm.addDestination("ATM Khâm Thiên","158 Khâm Thiên, Quận Đống Đa, Hà Nội", 21.0177285,105.8374322);

        hospital.addDestination("Bệnh viện Bạch Mai", "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội", 20.9954857,105.8445753);
        hospital.addDestination("Bệnh Viện Hữu Nghị", "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội", 21.0154614,105.857414);
        hospital.addDestination("Bệnh Viện E, Hà Nội","87 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội", 21.0494995,105.7985139);
        hospital.addDestination("Viện Răng Hàm Mặt", "40B – Tràng Thi – Hoàn Kiếm – Hà Nội", 21.0275153,105.8443653);
        hospital.addDestination("Bệnh Viện Tai Mũi Họng Trung Ương", "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội", 20.9996578,105.8384244);
        hospital.addDestination("Bệnh Viện Mắt Trung Ương", "85 – Phố Bà Triệu – Quận Hai Bà Trưng – Hà Nội", 21.0174613,105.8473821);
        hospital.addDestination("Viện Y Học Cổ Truyền Trung Ương", "29 – Phố Nguyễn Bỉnh Khiêm – Quận Hai Bà Trưng – Hà Nội", 21.0160865,105.8464341);
        hospital.addDestination("Bệnh Viện Nội Tiết", "80 – Thái Thịnh II – Thịnh Quang – Đống Đa – Hà Nội", 21.012304,105.8128827);
        hospital.addDestination("Bệnh Viện Việt Đức", "8 – Phố Phủ Doãn – Quận Hoàn Kiếm – Hà Nội", 21.0123037,105.8063166);
        hospital.addDestination("Bệnh Viện Nhi Trung Ương", "18/879 – Đường La Thành – Quận Đống Đa – Hà Nội", 21.0260951,105.8080656);

        hotel.addDestination("The Queen Hotel & Spa", "67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", 21.0346909,105.8460032);
        hotel.addDestination("Hanoi Nostalgia Hotel & Spa", "13-15 Luong Ngoc Quyen, Hang Buom, Hoan Kiem, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam", 21.034721,105.8508375);
        hotel.addDestination("Church Legend Hotel Hanoi", "46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", 21.0285972,105.8461626);
        hotel.addDestination("Little Hanoi Diamond Hotel", "11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", 21.0337023,105.8454016);
        hotel.addDestination("Flamingo Dai Lai Resort", "Thôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam", 21.033702,105.8388355);
        hotel.addDestination("Hanoi Zesty Hotel", "20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam", 21.0348844,105.8473259);
        hotel.addDestination("Bluebell Hotel", "41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", 21.029126,105.8462123);

        bus.addDestination("Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa", 21.0458403,105.8765538);
        bus.addDestination( "Tuyến 02", "Bác cổ - BX Yên Nghĩa", 20.949808,105.7452133);
        bus.addDestination( "Tuyến 03A", "BX Giáp Bát - BX Gia Lâm", 20.9802148,105.8392657);
        bus.addDestination( "Tuyến 03B", "Bx Giáp Bát - Vincom - Phúc Lợi", 21.0448543,105.9236868);
        bus.addDestination( "Tuyến 04", "Long Biên - BX Nước Ngầm", 20.9651144,105.8405745);
        bus.addDestination( "Tuyến 05", "Linh Đàm - Phú Diễn", 20.9714845,105.8278558);
        bus.addDestination( "Tuyến 06", "BX. Giáp Bát - Phú Minh (Phú Xuyên)", 20.9802148,105.8392657);
        bus.addDestination( "Tuyến 07", "Cầu Giấy - Nội Bài", 20.9871706,105.8252897);
        bus.addDestination( "Tuyến 08", "Long Biên - Đông Mỹ", 20.9154469,105.8746726);

        province.addOption(atm);
        province.addOption(hospital);
        province.addOption(hotel);
        province.addOption(bus);
        return province;
    }

}
