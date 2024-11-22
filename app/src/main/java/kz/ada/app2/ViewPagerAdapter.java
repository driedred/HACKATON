package kz.ada.app2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(MainActivity mainActivity) {
        super(mainActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HistoricalDataFragment();  // Исторические данные
            case 1:
                return new ForecastFragment();  // Прогноз
            case 2:
                return new NewsFragment();  // Новости
            default:
                return new HistoricalDataFragment();  // По умолчанию
        }
    }

    @Override
    public int getItemCount() {
        return 3; }}

