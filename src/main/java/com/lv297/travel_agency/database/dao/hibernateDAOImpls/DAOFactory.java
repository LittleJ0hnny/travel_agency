package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

public class DAOFactory {
    private CountryHibernateDAOImpl countryHibernateDAO;
    private CityHibernateDAOImpl cityHibernateDAO;
    private HotelHibernateDAOImpl hotelHibernateDAO;
    private RoomHibernateDAOImpl roomHibernateDAO;
    private BookingHibernateDAOImpl bookingHibernateDAO;
    private ClientHibernateDAOImpl clientHibernateDAO;
    private VisaHibernateDAOImpl visaHibernateDAO;

    private static DAOFactory instance;

    private DAOFactory() {
        countryHibernateDAO = new CountryHibernateDAOImpl();
        cityHibernateDAO = new CityHibernateDAOImpl();
        hotelHibernateDAO = new HotelHibernateDAOImpl();
        roomHibernateDAO = new RoomHibernateDAOImpl();
        bookingHibernateDAO = new BookingHibernateDAOImpl();
        clientHibernateDAO = new ClientHibernateDAOImpl();
        visaHibernateDAO = new VisaHibernateDAOImpl();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public CountryHibernateDAOImpl getCountryHibernateDAO() {
        return countryHibernateDAO;
    }

    public CityHibernateDAOImpl getCityHibernateDAO() {
        return cityHibernateDAO;
    }

    public HotelHibernateDAOImpl getHotelHibernateDAO() {
        return hotelHibernateDAO;
    }

    public RoomHibernateDAOImpl getRoomHibernateDAO() {
        return roomHibernateDAO;
    }

    public BookingHibernateDAOImpl getBookingHibernateDAO() {
        return bookingHibernateDAO;
    }

    public ClientHibernateDAOImpl getClientHibernateDAO() {
        return clientHibernateDAO;
    }

    public VisaHibernateDAOImpl getVisaHibernateDAO() {
        return visaHibernateDAO;
    }

}
