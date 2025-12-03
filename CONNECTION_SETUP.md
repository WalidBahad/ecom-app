# Frontend-Backend Connection Setup

## ✅ What I Just Fixed

I've added CORS (Cross-Origin Resource Sharing) configuration to all your backend services:

1. **Customer Service** - Added CORS to `RestRepositoryConfig.java`
2. **Inventory Service** - Added CORS to `RestRepositoryConfig.java`
3. **Billing Service** - Added `@CrossOrigin` annotation to `BillRestController.java`

## 🔄 Next Steps (IMPORTANT!)

### Step 1: Restart All Backend Services

**You MUST restart your Spring Boot services** for the CORS changes to take effect:

1. Stop all running Spring Boot services (Ctrl+C in each terminal)
2. Restart them in this order:
   - Discovery Service (Eureka)
   - Gateway Service
   - Customer Service
   - Inventory Service
   - Billing Service

### Step 2: Verify Backend is Accessible

Open your browser and test these URLs directly:

```
http://localhost:8080/api/customers
http://localhost:8080/api/products
http://localhost:8080/api/bills/1
```

**Expected**: You should see JSON responses (even if empty `{}` or `[]`)

**If you get errors**: 
- "Connection refused" = Services not running
- "404 Not Found" = Gateway routing issue
- CORS error = Services not restarted after CORS changes

### Step 3: Test Frontend Connection

1. Make sure frontend is running: `npm start` (in angular-frontend directory)
2. Open browser: http://localhost:4200
3. Open DevTools (F12) → Network tab
4. Click on "Customers" in the navigation
5. Look for API calls to `http://localhost:8080/api/customers`

**Check the status**:
- ✅ **200 OK** = Success! Connection working
- ❌ **CORS error** = Backend services not restarted
- ❌ **404** = Gateway routing issue
- ❌ **Connection refused** = Backend not running

### Step 4: Check Browser Console

Open Console tab (F12) and look for:
- ✅ No errors = Good!
- ❌ CORS errors = Restart backend services
- ❌ Network errors = Check backend is running

## 🧪 Quick Test

Run this in your browser console (on http://localhost:4200):

```javascript
fetch('http://localhost:8080/api/customers')
  .then(r => r.json())
  .then(data => console.log('✅ Success:', data))
  .catch(err => console.error('❌ Error:', err));
```

**Expected**: Should log customer data or empty response.

## 📋 Troubleshooting

### Problem: Still getting CORS errors
**Solution**: 
1. Make sure you restarted ALL backend services
2. Check that services are running on correct ports
3. Verify CORS configuration was saved correctly

### Problem: "Cannot GET /api/customers"
**Solution**:
1. Verify Gateway Service is running on port 8080
2. Check Eureka service discovery is working
3. Verify services are registered with Eureka

### Problem: Network error / Connection refused
**Solution**:
1. Start all backend services
2. Check services are on correct ports:
   - Gateway: 8080
   - Customer Service: (check application.properties)
   - Inventory Service: (check application.properties)
   - Billing Service: 8083 (from application.properties)

## ✅ Verification Checklist

Before testing the frontend:
- [ ] All backend services are running
- [ ] Services were restarted AFTER CORS changes
- [ ] Gateway service is on port 8080
- [ ] Can access http://localhost:8080/api/customers in browser
- [ ] Frontend is running on http://localhost:4200
- [ ] Browser DevTools Network tab shows API calls

## 🎯 Expected Result

After restarting backend services:
1. Frontend should load customer list (may be empty)
2. No CORS errors in browser console
3. Network tab shows successful API calls (200 status)
4. You can create/edit/delete customers and products

---

**Remember**: The key step is **restarting all backend services** after the CORS configuration changes!

